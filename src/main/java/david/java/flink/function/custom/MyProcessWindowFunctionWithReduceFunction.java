package david.java.flink.function.custom;

import david.java.flink.pojo.SensorReading;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午1:21 2021/1/15
 */
public class MyProcessWindowFunctionWithReduceFunction extends ProcessWindowFunction<SensorReading, Tuple2<Long, SensorReading>, String , TimeWindow>  {

    @Override
    public void process(String key, Context context, Iterable<SensorReading> iterable, Collector<Tuple2<Long, SensorReading>> collector) throws Exception {
        //跟aggregation  function一起后,聚合的结果只有一个,所以不用循环
        SensorReading min = iterable.iterator().next();
        collector.collect(new Tuple2<Long, SensorReading>(context.window().getStart(), min));
    }
}
