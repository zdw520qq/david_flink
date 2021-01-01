package david.java.flink.checkpoint;

import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Description:
 * @Author: david
 * @Date: Create in 下午6:09 2020/12/30
 */
public class CheckpointExample {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //开启checkpoint  ,间隔为1s
        env.enableCheckpointing(1000);

        //精确一次,也是默认的
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);

        //设置两个checkpoint间的间隔是 500ms
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(500);

        //设置超时时间为1min, 超时后,checkpoint抛弃
        env.getCheckpointConfig().setCheckpointTimeout(60000);

        //checkpoint的最大并行度是1, 也就是同一时间只能有1个checkpoint
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(1);

        //当job 取消的时候使用外部存储介质,保证checkpoint不消失
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);

        //允许barrier unalign模式的checkpoint
        env.getCheckpointConfig().enableUnalignedCheckpoints();

    }
}

