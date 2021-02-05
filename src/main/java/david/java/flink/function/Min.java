package david.java.flink.function;

import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: min 与 minBy的区别:
 * The difference between min and minBy is that min returns the minimum value, whereas minBy returns the element that
 * has the minimum value in this field (same for max and maxBy).
 * 看下面示例即可明白,min返回的是最小值, 但是minBy 返回的是这个这个元素
 * min只返回计算的最小值，而最小值对应的其他数据不保证正确。
 * minBy返回计算的最小值，并且最小值对应的其他数据是保证正确的。
 *
 *
 * @Author: David
 * @Date: Create in 下午6:19 2021/1/4
 */
public class Min {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //获取数据源
        List<Tuple3<Integer,Integer,Integer>> data = new ArrayList<>();
        data.add(new Tuple3<>(0,2,2));
        data.add(new Tuple3<>(0,1,1));
        data.add(new Tuple3<>(0,5,6));
        data.add(new Tuple3<>(0,3,5));
        data.add(new Tuple3<>(1,1,9));
        data.add(new Tuple3<>(1,2,8));
        data.add(new Tuple3<>(1,3,10));
        data.add(new Tuple3<>(1,2,9));

        DataStreamSource<Tuple3<Integer,Integer,Integer>> items = env.fromCollection(data);
        /**
         * 3> (0,2,2)
         * 3> (0,2,1)
         * 3> (0,2,1)
         * 3> (0,2,1)
         * 3> (1,1,9)
         * 3> (1,1,8)
         * 3> (1,1,8)
         * 3> (1,1,8)
         */
        items.keyBy(0).min(2).print();

        /**
         * 3> (0,2,2)
         * 3> (0,1,1)
         * 3> (0,1,1)
         * 3> (0,1,1)
         * 3> (1,1,9)
         * 3> (1,2,8)
         * 3> (1,2,8)
         * 3> (1,2,8)
         */
        items.keyBy(0).minBy(2).print();

        env.execute("defined streaming source");
    }

}
