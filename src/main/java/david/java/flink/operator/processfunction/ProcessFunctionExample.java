package david.java.flink.operator.processfunction;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午4:24 2021/2/3
 */
public class ProcessFunctionExample {
    public static void main(String[] args) {
        DataStream<Tuple2<String, String>> dataSource = null;

        DataStream<Tuple2<String, Long>> result = dataSource
                .keyBy(t -> t.f0)
                .process(new CountWithTimeoutFunction());


    }

    public static class CountWithTimestamp {
        public String key;
        public long count;
        public long lastModified;
    }


    public static class CountWithTimeoutFunction extends KeyedProcessFunction<String , Tuple2<String, String>, Tuple2<String, Long>> {
        private ValueState<CountWithTimestamp> state;

        @Override
        public void open(Configuration parameters) throws Exception {
            //获取state
            state = getRuntimeContext().getState(new ValueStateDescriptor<CountWithTimestamp>("myState", CountWithTimestamp.class));
        }


        @Override
        public void processElement(Tuple2<String, String> value, Context ctx, Collector<Tuple2<String, Long>> out) throws Exception {

            //获取当前的count
            CountWithTimestamp current = state.value();
            if (current == null) {
                current = new CountWithTimestamp();
                current.key = value.f0;
            }

            current.count++;
            current.lastModified = ctx.timestamp();

            state.update(current);

            //在currentTime 之后60秒 生成一个timer
            ctx.timerService().registerEventTimeTimer(current.lastModified + 60000);
        }

        @Override
        public void onTimer(long timestamp, OnTimerContext ctx, Collector<Tuple2<String, Long>> out) throws Exception {
            CountWithTimestamp value = state.value();

            if (timestamp == value.lastModified + 60000) {
                out.collect(new Tuple2<String ,Long>(value.key, value.count));
            }
            super.onTimer(timestamp, ctx, out);
        }
    }

}
