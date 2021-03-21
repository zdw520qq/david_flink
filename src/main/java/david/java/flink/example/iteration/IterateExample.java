package david.java.flink.example.iteration;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.IterativeStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午4:46 2021/3/11
 */
public class IterateExample {
    private static final  int BOUND = 100;

    public static void main(String[] args) {

        ParameterTool params = ParameterTool.fromArgs(args);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setBufferTimeout(1);

        env.getConfig().setGlobalJobParameters(params);
        DataStream<Tuple2<Integer, String >> inputStream;
        if (params.has("input")) {
            // inputStream = env.readTextFile(params.get("input")).map(new FibonacciInputMap());
        } else {
            System.out.println("Executing Iterate example with default ");
            System.out.println("use --input");
            // inputStream = env.addSource(new RandomFibonacciSource());
        }

        // IterativeStream<Tuple5<Integer ,Integer ,Integer ,Integer ,Integer >> it = inputStream.map(new InputMap()).iterate(5000L)




    }

}
