package david.java.flink.watermark;

import david.java.flink.pojo.MyEvent;
import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkOutput;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 上午11:50 2020/12/21
 */
public class PunctuatedAssigner implements WatermarkGenerator<MyEvent> {
    @Override
    public void onEvent(MyEvent myEvent, long l, WatermarkOutput watermarkOutput) {
        if (myEvent.hasWatermarkMarker()) {
            watermarkOutput.emitWatermark(new Watermark(myEvent.getWatermarkTimestamp()));
        }
    }

    @Override
    public void onPeriodicEmit(WatermarkOutput watermarkOutput) {
        // don't need to do anything because we emit in reaction to events above
    }
}
