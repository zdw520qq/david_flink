package david.java.flink.function;

import david.java.flink.function.custom.AverageAggregate;
import david.java.flink.function.custom.MyProcessWindowFunctionWithReduceFunction;
import david.java.flink.function.custom.MyReduceFunctionWithProcess;
import david.java.flink.function.custom.MyprocessWindowFunction;
import david.java.flink.pojo.SensorReading;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.OutputTag;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:53 2021/1/6
 */
public class WindowFunction {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Tuple2<String, Long>> input = env.fromElements(Tuple2.of("1", 3L), Tuple2.of("1", 5L), Tuple2.of("1", 7L), Tuple2.of("1", 4L), Tuple2.of("2", 2L));


        WindowedStream<Tuple2<String, Long>, Tuple, TimeWindow> window = input.keyBy(0)
                .window(TumblingProcessingTimeWindows.of(Time.minutes(1)));

        /**
         * reduce function
         */
        window
                // .reduce((ReduceFunction<Tuple2<String, Long>>) (t1, t2) -> new Tuple2<>(t1.f0, t1.f1 + t2.f1));
                .reduce(new ReduceFunction<Tuple2<String, Long>>() {
                    @Override
                    public Tuple2<String, Long> reduce(Tuple2<String, Long> t1, Tuple2<String, Long> t2) throws Exception {
                        return new Tuple2<>(t1.f0, t1.f1 + t2.f1);
                    }
                });


        /**
         * aggregatefunction
         */
        window.aggregate(new AverageAggregate());


        /**
         * processFunction
         */
        input.keyBy(t -> t.f0)
                .window(TumblingProcessingTimeWindows.of(Time.minutes(1)))
                .process(new MyprocessWindowFunction());


        /**
         * processWindowFunction with incremental Aggregation
         */
        DataStreamSource<SensorReading> input4 = env.fromElements(new SensorReading());

        input4.keyBy(t -> t.name)
                .window(TumblingProcessingTimeWindows.of(Time.minutes(1)))
                .reduce(new MyReduceFunctionWithProcess(), new MyProcessWindowFunctionWithReduceFunction());


        /**
         * allowed lateness
         */
        input4.keyBy(t -> t.name)
                .window(TumblingProcessingTimeWindows.of(Time.minutes(1)))
                .allowedLateness(Time.milliseconds(1000))
                .reduce(new MyReduceFunctionWithProcess(), new MyProcessWindowFunctionWithReduceFunction());


        /**
         * side output
         */
        final OutputTag<SensorReading> lateOutOutTag = new OutputTag<>("late-date");

        SingleOutputStreamOperator<Tuple2<Long, SensorReading>> result = input4.keyBy(t -> t.name)
                .window(TumblingProcessingTimeWindows.of(Time.minutes(1)))
                .allowedLateness(Time.milliseconds(1000))
                .sideOutputLateData(lateOutOutTag)
                .reduce(new MyReduceFunctionWithProcess(), new MyProcessWindowFunctionWithReduceFunction());
        //取出侧输出流
        DataStream<SensorReading> sideOutput = result.getSideOutput(lateOutOutTag);

    }
}
