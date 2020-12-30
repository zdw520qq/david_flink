package david.java.flink.example;

import david.java.flink.datasources.CustomSource;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import scala.Tuple3;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午1:21 2020/12/18
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Tuple3<String, Long, Long>> data = env.addSource(new CustomSource());
        SingleOutputStreamOperator<Object> map = data.map(x -> {
            System.out.println("print\t" + x._1() + "\t" + x._2() + "\t" + x._3());
            return x;
        });
        map.print();

        env.execute("word count");
    }
}
