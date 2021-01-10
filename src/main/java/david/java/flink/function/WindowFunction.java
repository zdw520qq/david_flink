package david.java.flink.function;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:53 2021/1/6
 */
public class WindowFunction {
    public static void main(String[] args) {
        DataStream<Tuple2<String, Long>> input = null;

        WindowedStream<Tuple2<String, Long>, Tuple, TimeWindow> window = input.keyBy(0)
                .window(TumblingEventTimeWindows.of(Time.minutes(1)));
        window
                // lambda
                // .reduce((ReduceFunction<Tuple2<String, Long>>) (t1, t2) -> new Tuple2<>(t1.f0, t1.f1 + t2.f1));
                .reduce(new ReduceFunction<Tuple2<String, Long>>() {
                    @Override
                    public Tuple2<String, Long> reduce(Tuple2<String, Long> t1, Tuple2<String, Long> t2) throws Exception {
                        return new Tuple2<>(t1.f0, t1.f1 + t2.f1);
                    }
                });


    }
}
