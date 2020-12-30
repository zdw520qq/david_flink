package david.scala.flink.watermark

import david.java.flink.pojo.MyEvent
import org.apache.flink.api.common.eventtime.{Watermark, WatermarkGenerator, WatermarkOutput}


/**
 * @Description: there is a mistake about BoundedOutOfOrdernessGenerator on offical  webset
 * @Author: Zhaodawei
 * @Date: Create in 下午12:43 2020/12/21 
 */
class BoundedOutOfOrdernessGenerator extends WatermarkGenerator[MyEvent] {
//class BoundedOutOfOrdernessGenerator extends AssignerWithPeriodicWatermarks[MyEvent] {
    val maxOutOfOrderness = 3500L
    var currentMaxTimestamp: Long = _

    override def onEvent(t: MyEvent, l: Long, watermarkOutput: WatermarkOutput): Unit = {
        currentMaxTimestamp = Math.max(l, currentMaxTimestamp)
    }

    override def onPeriodicEmit(watermarkOutput: WatermarkOutput): Unit = {
        watermarkOutput.emitWatermark(new Watermark(currentMaxTimestamp - maxOutOfOrderness - 1))
    }
}
