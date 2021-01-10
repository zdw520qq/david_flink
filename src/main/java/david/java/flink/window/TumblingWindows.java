package david.java.flink.window;

import david.java.flink.pojo.Item;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午1:14 2021/1/5
 */
public class TumblingWindows {
    public static void main(String[] args) {
        DataStream<Item> input = null;

        // tumbling event-time windows
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(TumblingEventTimeWindows.of(Time.seconds(5)));


        // tumbling processing-time windows
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(5)));

        // 每天一个滚动窗口, 因为flink 时间是 epochTime, 即UTC-0 时区, 因此要offset8小时 ,才是北京
        // tumbling event-time windows  offset by -8 hours
        input.keyBy((KeySelector<Item, String >) item -> item.color)
                .window(TumblingEventTimeWindows.of(Time.days(1), Time.hours(-8)));

    }
}
