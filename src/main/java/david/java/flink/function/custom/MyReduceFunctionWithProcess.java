package david.java.flink.function.custom;

import david.java.flink.pojo.SensorReading;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午1:28 2021/1/15
 */
public class MyReduceFunctionWithProcess implements ReduceFunction<SensorReading> {
    @Override
    public SensorReading reduce(SensorReading r1, SensorReading r2) throws Exception {
        return r1.value > r2.value ? r2 : r1;
    }
}
