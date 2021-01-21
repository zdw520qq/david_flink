package david.java.flink.function.custom;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午12:17 2021/1/18
 */
public class MyProcessWindowFunctionWithAggregate extends ProcessWindowFunction< Double, Tuple2<String ,Double>, String , TimeWindow> {
    @Override
    public void process(String key, Context context, Iterable<Double> iterable, Collector<Tuple2<String, Double>> collector) throws Exception {
        Double next = iterable.iterator().next();
        collector.collect(new Tuple2<>(key, next));
    }
}
