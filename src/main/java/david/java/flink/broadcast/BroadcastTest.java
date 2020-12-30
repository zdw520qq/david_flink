package david.java.flink.broadcast;

import david.java.flink.pojo.Color;
import david.java.flink.pojo.Item;
import david.java.flink.pojo.Rule;
import david.java.flink.pojo.Shape;
import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.typeutils.ListTypeInfo;
import org.apache.flink.streaming.api.datastream.BroadcastStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.KeyedBroadcastProcessFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: Note that:
 * 没有跨 task 通讯：如上所述，这就是为什么只有在 (Keyed)-BroadcastProcessFunction 中处理广播流元素的方法里可以更改 broadcast state 的内容。
 * 同时，用户需要保证所有 task 对于 broadcast state 的处理方式是一致的，否则会造成不同 task 读取 broadcast state 时内容不一致的情况，最终导致结果不一致。
 *
 * broadcast state 在不同的 task 的事件顺序可能是不同的：虽然广播流中元素的过程能够保证所有的下游 task 全部能够收到，但在不同 task 中元素
 * 的到达顺序可能不同。 所以 broadcast state 的更新不能依赖于流中元素到达的顺序。
 *
 * 所有的 task 均会对 broadcast state 进行 checkpoint：虽然所有 task 中的 broadcast state 是一致的，但当 checkpoint 来临时所有
 * task 均会对 broadcast state 做 checkpoint。 这个设计是为了防止在作业恢复后读文件造成的文件热点。当然这种方式会造成 checkpoint
 * 一定程度的写放大，放大倍数为 p（=并行度）。Flink 会保证在恢复状态/改变并发的时候数据没有重复且没有缺失。 在作业恢复时，如果与之前具有相同
 * 或更小的并发度，所有的 task 读取之前已经 checkpoint 过的 state。在增大并发的情况下，task 会读取本身的 state，多出来的并发（p_new - p_old）
 * 会使用轮询调度算法读取之前 task 的 state。
 *
 * 非RocksDB state backend： broadcast state 在运行时保存在内存中，需要保证内存充足。这一特性同样适用于所有其他 Operator State。
 * @Author: Zhaodawei
 * @Date: Create in 上午9:54 2020/12/23
 */
public class BroadcastTest {
    public static void main(String[] args) {

        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item());

        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new Rule());

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Item> source = env.fromCollection(list);
        DataStreamSource<Rule> rule = env.fromCollection(rules);


        /***
         * param1: name,
         * param2: key type,
         * param3: value type
         */
        MapStateDescriptor<String ,Rule> ruleMapStateDescriptor = new MapStateDescriptor<>(
                "RuleBroadcastState",
                BasicTypeInfo.STRING_TYPE_INFO,
                TypeInformation.of(new TypeHint<Rule>() {
                })
        );

        KeyedStream<Item, Color> colorPartitonedStream = source.keyBy(new KeySelector<Item, Color>() {
            @Override
            public Color getKey(Item item) throws Exception {
                return new Color();
            }
        });

        BroadcastStream<Rule> ruleBroadcastStream = rule.broadcast(ruleMapStateDescriptor);

        colorPartitonedStream
                .connect(ruleBroadcastStream)
                .process(
                        new KeyedBroadcastProcessFunction<Color, Item, Rule, String>() {

                            //非broadcast流, 使用的state
                            private final MapStateDescriptor<String, List<Item>> mapStateDescriptor =
                                    new MapStateDescriptor<String, List<Item>>(
                                            "items",
                                            BasicTypeInfo.STRING_TYPE_INFO,
                                            new ListTypeInfo<>(Item.class));

                            //broadcast  ,使用的state
                            private final MapStateDescriptor<String ,Rule> ruleMapStateDescriptor =
                                    new MapStateDescriptor<String, Rule>(
                                            "ruleBroadcast",
                                            BasicTypeInfo.STRING_TYPE_INFO,
                                            TypeInformation.of(new TypeHint<Rule>() {}));

                            /**
                             * broadcast流
                             */
                            @Override
                            public void processBroadcastElement(Rule rule, Context ctx, Collector<String> collector) throws Exception {
                                //将broadcast流的 element装入state中
                                ctx.getBroadcastState(ruleMapStateDescriptor).put(rule.name, rule);
                            }

                            /**
                             *  非broadcast流
                             */
                            @Override
                            public void processElement(Item value, ReadOnlyContext ctx, Collector<String> collector) throws Exception {
                                //拿出自身的state
                                final MapState<String ,List<Item>> state = getRuntimeContext().getMapState(mapStateDescriptor);
                                //element 是item
                                final Shape shape = value.shape;
                                //从broadcast中获取广播变量,并遍历匹配element
                                for (Map.Entry<String ,Rule> entry: ctx.getBroadcastState(ruleMapStateDescriptor).immutableEntries()) {
                                    final String ruleName = entry.getKey();
                                    final Rule rule = entry.getValue();

                                    List<Item> stateValueList = state.get(ruleName);

                                    if (stateValueList == null) {
                                        stateValueList = new ArrayList<>();
                                    }
                                    //如果element匹配到了broadcast中的第二个规则,则发送出去
                                    if(shape == rule.second && !stateValueList.isEmpty()) {
                                        //遍历非广播流中state,完事后clear掉
                                        for (Item i : stateValueList) {
                                            collector.collect("MATCH:" + i + "-"+ value);
                                        }
                                        stateValueList.clear();
                                    }
                                    //如果新来的element匹配到了broadcast中的第1个规则,则加入state
                                    if(shape.equals(rule.first)) {
                                        stateValueList.add(value);
                                    }
                                    //如果state里面的value是空的,那就没必要留着这个state了,删掉, 否则加入state
                                    if (stateValueList.isEmpty()) {
                                        state.remove(ruleName);
                                    } else {
                                        state.put(ruleName, stateValueList);
                                    }
                                }
                            }

                            @Override
                            public void onTimer(long timestamp, OnTimerContext ctx, Collector<String> out) throws Exception {
                                super.onTimer(timestamp, ctx, out);
                            }
                        }
                );

    }


}
