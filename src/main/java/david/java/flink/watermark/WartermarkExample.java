package david.java.flink.watermark;

import java.time.Duration;

import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.io.FilePathFilter;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.FileProcessingMode;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午3:00 2020/12/18
 */
public class WartermarkExample {
    public static void main(String[] args) {

        // example 01
        // 通常我们不用去实现TimestampAssignerSupplier, WatermarkGeneratorSupplier,这两个接口,使用静态方法和lambda生成timestamp就行
        WatermarkStrategy
                .<Tuple2<Long, String>>forBoundedOutOfOrderness(Duration.ofSeconds(20))
                .withTimestampAssigner((event, timestamp) -> event.f0);


        // example 02
        // it's only a illustate ,so dont't mind about the param that not defined
        /*
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<MyEvent> stream = env.readFile(myFormat,
                myFilePath,
                FileProcessingMode.PROCESS_CONTINUOUSLY,
                100,
                FilePathFilter.createDefaultFilter(),
                typeInfo);

        DataStream<MyEvent> withTimestampAndWatermarks = stream
                .filter(event -> event.severity() == WARNING)
                .assignTimestampsAndWatermarks( < watermark strategy >);

        withTimestampAndWatermarks
                .keyBy((event) -> event.getGroup())
                .window(TumblingEventTimeWindows.of(Time.seconds(10)))
                .reduce((a, b) -> a.add(b))
                .addSink(...)
                */

        // example 03
        //dealing with idle sources
        WatermarkStrategy.<Tuple2<Long,String >>forBoundedOutOfOrderness(Duration.ofSeconds(20))
                .withIdleness(Duration.ofMinutes(1));



    }
}
