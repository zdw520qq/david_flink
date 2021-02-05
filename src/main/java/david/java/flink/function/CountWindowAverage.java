package david.java.flink.function;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午3:15 2020/12/21
 */
public class CountWindowAverage extends RichFlatMapFunction<Tuple2<Long, Long>, Tuple2<Long, Long>> {
    private transient ValueState<Tuple2<Long, Long>> sum ;

    @Override
    public void flatMap(Tuple2<Long, Long> input, Collector<Tuple2<Long, Long>> collector) throws Exception {
        Tuple2<Long, Long> currentSum = sum.value();

        currentSum.f0 += 1;

        currentSum.f1 += input.f1;

        sum.update(currentSum);

        if (currentSum.f0 >= 2) {
            collector.collect(new Tuple2<>(input.f0, currentSum.f1 / currentSum.f0));
            sum.clear();
        }
    }

    @Override
    public void open(Configuration config) throws Exception {

        //StateTtlConfig ttlConfig = StateTtlConfig
        //        .newBuilder(Time.seconds(10))
        //        .setUpdateType(StateTtlConfig.UpdateType.OnCreateAndWrite)
        //        .setStateVisibility(StateTtlConfig.StateVisibility.NeverReturnExpired)
        //        .build();

        ValueStateDescriptor<Tuple2<Long, Long>> descriptor = new ValueStateDescriptor<Tuple2<Long, Long>>(
                "average", // state name
                TypeInformation.of(new TypeHint<Tuple2<Long, Long>>() {}), //type infornation
                Tuple2.of(0L, 0L)   // default value of state if nothing was set
        );
        //descriptor.enableTimeToLive(ttlConfig);
        sum = getRuntimeContext().getState(descriptor);
    }


    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(Tuple2.of(1L, 3L), Tuple2.of(1L, 5L), Tuple2.of(1L, 7L), Tuple2.of(1L, 4L), Tuple2.of(1L, 2L))
                .keyBy(value -> value.f0)
                .flatMap(new CountWindowAverage())
                .print();

        env.execute("");

    }
}
