package david.java.flink.operator.processfunction;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午4:24 2021/2/3
 */
public class ProcessFunctionExample {
    public static void main(String[] args) {
        DataStream<Tuple2<String,String >> dataSource = null;

        DataStream<Tuple2<String, Long>> result = dataSource
                .keyBy(t -> t.f0)
                .process(new CountWithTimeoutFunction());









    }

    c


}
