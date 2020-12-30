package david.scala.flink.example

import java.lang

import david.scala.flink.datasource.CustomSource
import org.apache.flink.streaming.api.datastream.DataStreamSource
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 上午10:17 2020/12/14
 */
object worldCount {

    def main(args: Array[String]): Unit = {

        val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
        val value1: DataStreamSource[(String, Long, Long)] = env.addSource(new CustomSource)
        value1.print()

        //        val value: DataStreamSource[String] = env.socketTextStream("localhost", 7777)
        //        value.print()


        env.execute("world count")


    }

}
