package david.scala.flink.watermark

import david.java.flink.pojo.MyEvent
import org.apache.flink.api.common.eventtime.{Watermark, WatermarkGenerator, WatermarkOutput}

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午1:31 2020/12/21 
 */
class PunctuateAssigner extends WatermarkGenerator[MyEvent]{
    override def onEvent(t: MyEvent, l: Long, watermarkOutput: WatermarkOutput): Unit = {
        if (t.hasWatermarkMarker) {
            watermarkOutput.emitWatermark(new Watermark(t.getWatermarkTimestamp))
        }
    }

    override def onPeriodicEmit(watermarkOutput: WatermarkOutput): Unit = ???
}
