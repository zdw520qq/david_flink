package david.scala.flink.watermark

import david.java.flink.pojo.MyEvent
import org.apache.flink.api.common.eventtime.{Watermark, WatermarkGenerator, WatermarkOutput}

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午1:21 2020/12/21 
 */
class TimeLagWatermarkGenerator extends WatermarkGenerator[MyEvent]{

    val maxTimeLag: Long = 5000L

    override def onEvent(t: MyEvent, l: Long, watermarkOutput: WatermarkOutput): Unit = {
        // pass
    }

    override def onPeriodicEmit(watermarkOutput: WatermarkOutput): Unit = {
        watermarkOutput.emitWatermark(new Watermark(System.currentTimeMillis() - maxTimeLag))
    }
}
