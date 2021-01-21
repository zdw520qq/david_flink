package david.java.flink.function.custom;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @Description: 这个函数会把所有的元素缓存起来,最后通过trigger触发后,执行,代价是性能和资料的耗费
 *
 * key 分区的key
 * Context 此window的context
 * iterable 缓存的elements,等待被计算
 * collector 发出去的元素
 *
 *
 *
 * @Author: David
 * @Date: Create in 下午3:06 2021/1/13
 */
public class MyprocessWindowFunction extends ProcessWindowFunction<Tuple2<String ,Long>, String ,String , TimeWindow> {
    @Override
    public void process(String key, Context context, Iterable<Tuple2<String, Long>> iterable, Collector<String> collector) throws Exception {
        long count = 0;
        for (Tuple2<String , Long> in : iterable) {
            count ++;
        }
        String out = "window: " + context.window() + "count: " + count;
        System.out.println(out);
        collector.collect(out);
    }
}











