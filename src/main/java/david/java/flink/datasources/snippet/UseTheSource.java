package david.java.flink.datasources.snippet;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.connector.source.*;
import org.apache.flink.core.io.SimpleVersionedSerializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:52 2021/3/2
 */
public class UseTheSource {
    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Source mySource = new MySource();

        DataStream<Integer> stream = env.fromSource(
                mySource,
                WatermarkStrategy.noWatermarks(),
                "MySourceName"
        );

    }
}


class MySource implements Source {

    @Override
    public Boundedness getBoundedness() {
        return null;
    }

    @Override
    public SourceReader createReader(SourceReaderContext sourceReaderContext) throws Exception {
        return null;
    }

    @Override
    public SplitEnumerator createEnumerator(SplitEnumeratorContext splitEnumeratorContext) throws Exception {
        return null;
    }

    @Override
    public SplitEnumerator restoreEnumerator(SplitEnumeratorContext splitEnumeratorContext, Object o) throws Exception {
        return null;
    }

    @Override
    public SimpleVersionedSerializer getSplitSerializer() {
        return null;
    }

    @Override
    public SimpleVersionedSerializer getEnumeratorCheckpointSerializer() {
        return null;
    }
}
