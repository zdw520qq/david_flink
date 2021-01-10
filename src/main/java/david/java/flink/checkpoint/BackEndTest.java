package david.java.flink.checkpoint;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Description: 使用配置文件flink-conf.yaml的参数, 但是会被代码中的配置覆盖
 * @Author: David
 * @Date: Create in 下午1:02 2021/1/4
 */
public class BackEndTest {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // env.setStateBackend(...);

    }
}
