package david.java.flink.watermark;

import david.java.flink.pojo.MyEvent;
import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkOutput;

/**
 * @Description: a periodic watermark work on event time
 * ExecutionConfig.setAutoWatermarkInterval(...)   define watermark interval
 * @Author: Zhaodawei
 * @Date: Create in 下午5:43 2020/12/18
 */
public class BoundedOutOfOrdernessGenerator implements WatermarkGenerator<MyEvent> {

    private final long maxOutOfOrderness = 3500;

    private long currentMaxTimestamp;

    @Override
    public void onEvent(MyEvent myEvent, long eventTimestamp, WatermarkOutput watermarkOutput) {
        currentMaxTimestamp = Math.max(currentMaxTimestamp, eventTimestamp);
    }

    @Override
    public void onPeriodicEmit(WatermarkOutput output) {
        output.emitWatermark(new Watermark(currentMaxTimestamp - maxOutOfOrderness -1));
    }
}
