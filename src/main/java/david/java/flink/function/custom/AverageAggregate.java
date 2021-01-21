package david.java.flink.function.custom;

import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * @Description: 用来求平均数
 * 此function 一共3个参数:
 * 1. in
 * 2. accumulator  用来保存统计结果
 * 3. out
 * @Author: David
 * @Date: Create in 上午9:33 2021/1/11
 */
public class AverageAggregate implements AggregateFunction<Tuple2<String, Long>, Tuple2<Long, Long>, Double> {
    /**
     * step 1
     */
    @Override
    public Tuple2<Long, Long> createAccumulator() {
        return new Tuple2<>(0L, 0L);
    }

    /**
     * step 2
     */
    @Override
    public Tuple2<Long, Long> add(Tuple2<String, Long> value, Tuple2<Long, Long> accumulator) {
        return new Tuple2<>(accumulator.f0 + value.f1, accumulator.f1++);
    }

    /**
     * step 3
     */
    @Override
    public Tuple2<Long, Long> merge(Tuple2<Long, Long> accumulator1, Tuple2<Long, Long> accumulator2) {
        return new Tuple2<>(accumulator1.f0 + accumulator2.f0, accumulator1.f1 + accumulator2.f1);
    }

    /**
     * step 4
     */
    @Override
    public Double getResult(Tuple2<Long, Long> accumulator) {
        return ((double) accumulator.f0) / accumulator.f1;
    }


}
