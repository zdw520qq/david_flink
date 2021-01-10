package david.java.flink.window;

import david.java.flink.pojo.Item;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:42 2021/1/6
 */
public class GlobalWindow {
    public static void main(String[] args) {
        DataStream<Item> input = null;

        input.keyBy(0)
                .window(GlobalWindows.create());


    }
}
