package david.java.flink.watermark;

import java.time.Duration;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午2:11 2020/12/21
 */
public class KafkaWatermark {

    public static void main(String[] args) {
        //FlinkKafkaConsumer<MyType> kafkaSource = new FlinkKafkaConsumer<>("myTopic", schema, props);
        //kafkaSource.assignTimestampsAndWatermarks(
        //        WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofSeconds(20)
        //        WatermarkStrategy.forMonotonousTimestamps()
                //);
        //env.addsource(kafkaSource);

    }
}
