package david.scala.flink.function


import org.apache.flink.api.common.functions.ReduceFunction
import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.datastream.{DataStream, WindowedStream}
import org.apache.flink.streaming.api.windowing.assigners.{TumblingEventTimeWindows, TumblingProcessingTimeWindows}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow

import org.apache.flink.streaming.api.scala._
import scala.collection.JavaConversions._


/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午6:48 2021/1/6 
 */
object WindowFunction {
  def main(args: Array[String]): Unit = {
    val input: DataStream[(String, Long)] = null

    val value: WindowedStream[(String, Long), Tuple, TimeWindow] = input.keyBy(0)
      .window(TumblingProcessingTimeWindows.of(Time.minutes(1)))
    //      .window(TumblingEventTimeWindows.of(Time.minutes(1)))


    //        value.reduce { (v1, v2) => (v1._1, v1._2 + v2._2) }
    //    value.reduceBy((v1, v2) => (v1._1, v1._2 + v2._2))


  }

}
