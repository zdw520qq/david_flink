package david.java.flink.side_output;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午6:13 2021/3/2
 */
public class SideOutputDemo {
    public static void main(String[] args) {
        DataStream<Integer> input = null;

        final OutputTag<String > outputTag = new OutputTag<String>("side-output") {} ;

        SingleOutputStreamOperator<Integer> mainDataStream = input
                .process(new ProcessFunction<Integer, Integer>() {
                    @Override
                    public void processElement(Integer value, Context ctx, Collector<Integer> out) throws Exception {
                        out.collect(value);

                        ctx.output(outputTag, "sideout-" + String.valueOf(value));
                    }
                });


        DataStream<String> sideOutput = mainDataStream.getSideOutput(outputTag);


    }
}
