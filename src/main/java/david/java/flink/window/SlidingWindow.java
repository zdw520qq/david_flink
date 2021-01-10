package david.java.flink.window;

import david.java.flink.pojo.Item;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;


/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午1:16 2021/1/6
 */
public class SlidingWindow {
    public static void main(String[] args) {
        DataStream<Item> input = null;

        // sliding event-time window
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(SlidingEventTimeWindows.of(Time.seconds(10), Time.seconds(5)));


        // slinding processint time window
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(SlidingProcessingTimeWindows.of(Time.seconds(10), Time.seconds(5)));

        //sliding prcessing time  window offset by -8 hours
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(SlidingProcessingTimeWindows.of(Time.hours(12), Time.hours(1), Time.hours(-8)));

    }
}
