package david.scala.flink.datasource

import org.apache.flink.streaming.api.functions.source.SourceFunction

import scala.util.Random;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 上午11:08 2020/12/18 
 */
class CustomSource extends SourceFunction[(String, Long, Long)] {

    var isRunning: Boolean = true;
    private val random: Random = new Random()
    val names: Array[String] = Array("汝庚老师", "王嫂", "范大侠")

    override def run(sourceContext: SourceFunction.SourceContext[(String, Long, Long)]) = {
        while (isRunning) {

            val i: Int = random.nextInt(3)
            val name: String = names(i)
            Thread.sleep(1000)

            sourceContext.collect((name, System.currentTimeMillis(), System.currentTimeMillis() - 24L * 3600 * 1000)
            )
        }
    }

    override def cancel() = {
        isRunning = !isRunning
    }
}
