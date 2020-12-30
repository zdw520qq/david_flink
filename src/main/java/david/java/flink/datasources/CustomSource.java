package david.java.flink.datasources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.flink.streaming.api.functions.source.SourceFunction;
import scala.Tuple3;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午6:33 2020/12/14
 */
public class CustomSource implements SourceFunction<Tuple3<String, Long, Long>> {
    private volatile boolean isRunning = true;
    private List<String> nameList = new ArrayList<>(Arrays.asList("汝庚老师", "王嫂", "范大侠"));
    Random random = new Random();

    @Override
    public void run(SourceContext<Tuple3<String, Long, Long>> sourceContext) throws Exception {
        while (isRunning) {
            int index = random.nextInt(3);
            String name = nameList.get(index);


            Tuple3<String, Long, Long> tuple = new Tuple3<>(name, System.currentTimeMillis(), System.currentTimeMillis() - 24L * 3600 * 1000);
            //System.out.println("datasource ===> " + tuple);
            Thread.sleep(1000);
            sourceContext.collect(tuple);
        }
    }

    @Override
    public void cancel() {
        isRunning = !isRunning;
    }

    public static void main(String[] args) {
    }
}
