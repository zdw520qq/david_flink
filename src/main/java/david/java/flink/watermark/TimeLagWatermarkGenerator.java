package david.java.flink.watermark;

import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkOutput;

/**
 * @Description: a periodic watermark work on processing time
 * @Author: Zhaodawei
 * @Date: Create in 上午11:01 2020/12/21
 */
public class TimeLagWatermarkGenerator implements WatermarkGenerator {
    private final long maxTimeLag = 5000;

    @Override
    public void onEvent(Object o, long l, WatermarkOutput watermarkOutput) {
        // don't need to do anything because we work on peocessing time
    }

    @Override
    public void onPeriodicEmit(WatermarkOutput watermarkOutput) {
        watermarkOutput.emitWatermark(new Watermark(System.currentTimeMillis() - maxTimeLag));
    }
}
