package david.java.flink.operator.joining;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:54 2021/1/27
 */
public class WindowJoin {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Integer> orangeStream = env.fromElements(1, 2, 3);
        DataStream<Integer> greenStream = env.fromElements(2, 3, 4);

        // tumbling window join
        DataStream<String> apply = orangeStream.join(greenStream)
                .where(t -> t)
                .equalTo(t -> t)
                .window(TumblingEventTimeWindows.of(Time.milliseconds(2)))
                // .apply((JoinFunction<Integer, Integer, String >)(t1, t2) ->(t1 + "," + t2))  //lambda
                .apply(new JoinFunction<Integer, Integer, String>() {
                    @Override
                    public String join(Integer integer, Integer integer2) throws Exception {
                        return integer + "," + integer2;
                    }
                });
        apply.print();


        orangeStream
                .keyBy(t -> t)
                .intervalJoin(greenStream.keyBy(t -> t))
                .between(Time.milliseconds(-2), Time.milliseconds(1));





    }


}
