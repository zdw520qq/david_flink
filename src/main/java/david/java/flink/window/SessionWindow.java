package david.java.flink.window;

import david.java.flink.pojo.Item;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.SessionWindowTimeGapExtractor;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午1:26 2021/1/6
 */
public class SessionWindow {
    public static void main(String[] args) {
        DataStream<Item> input = null;

        // event time session windows with static gap
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(EventTimeSessionWindows.withGap(Time.minutes(10)));

        // event time time session with dynamic gap
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(EventTimeSessionWindows.withDynamicGap((element) -> {
                    //determine and return seesion gap
                    return 0;
                }));


        // processing time session with staitic gap
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(ProcessingTimeSessionWindows.withGap(Time.minutes(10)));



        // processing time session with dynamic gap
        input.keyBy((KeySelector<Item, String>) item -> item.color)
                .window(ProcessingTimeSessionWindows.withDynamicGap(
                        new SessionWindowTimeGapExtractor<Item>() {
                            @Override
                            public long extract(Item item) {
                                return 0;
                            }
                        }
                ));


    }
}
