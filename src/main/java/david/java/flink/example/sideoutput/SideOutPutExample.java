package david.java.flink.example.sideoutput;

import david.java.flink.example.utils.WordCountData;
import org.apache.flink.api.common.eventtime.*;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午8:24 2021/3/14
 */
public class SideOutPutExample {
    public static final OutputTag<String> rejectedWordsTag = new OutputTag<String>("rejected"){};

    public static void main(String[] args) throws Exception {

        ParameterTool params = ParameterTool.fromArgs(args);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setStreamTimeCharacteristic(TimeCharacteristic.IngestionTime);
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);

        env.getConfig().setGlobalJobParameters(params);

        DataStream<String> text;
        if (params.has("input")) {
            text = env.readTextFile(params.get("input"));
        } else {
            System.out.println("executing wordcount exammple with default input date set.");
            System.out.println("use --input to specify file input.");

            text = env.fromElements(WordCountData.WORDS);
        }

        text.assignTimestampsAndWatermarks(IngestionTimeWatemarkStrategy.create());

        SingleOutputStreamOperator<Tuple2<String ,Integer>> tokenized = text.keyBy(new KeySelector<String, Integer>() {
            @Override
            public Integer getKey(String value) throws Exception {
                return 0;
            }
        }).process(new Tokenizer());

        SingleOutputStreamOperator<String> rejectedWord = tokenized.getSideOutput(rejectedWordsTag)
                .map(new MapFunction<String, String>() {
                    @Override
                    public String map(String value) throws Exception {
                        return "rejected: " + value;
                    }
                });


        SingleOutputStreamOperator<Tuple2<String, Integer>> counts = tokenized.keyBy(0)
                .window(TumblingEventTimeWindows.of(Time.seconds(5)))
                .sum(1);

        counts.writeAsText("src/sideoutput");
        rejectedWord.writeAsText("src/sideoutput-reject");

        env.execute("text");

    }


    public static final class Tokenizer extends ProcessFunction<String, Tuple2<String, Integer>> {
        @Override
        public void processElement(String value,
                                   Context ctx,
                                   Collector<Tuple2<String, Integer>> out) throws Exception {
            String[] tokens = value.toLowerCase().split("\\W+");

            for (String token : tokens) {
                if (token.length() > 5) {
                    ctx.output(rejectedWordsTag, token);
                } else if (token.length() > 0) {
                    out.collect(new Tuple2<>(token, 1));
                }
            }
        }


    }

    private static class IngestionTimeWatemarkStrategy<T> implements WatermarkStrategy<T> {
        private IngestionTimeWatemarkStrategy() {
        }

        public static <T> IngestionTimeWatemarkStrategy<T> create() {
            return new IngestionTimeWatemarkStrategy<>();
        }

        @Override
        public WatermarkGenerator<T> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
            return new AscendingTimestampsWatermarks<>();
        }

        @Override
        public TimestampAssigner<T> createTimestampAssigner(TimestampAssignerSupplier.Context context) {
            return (event, timestamp) ->   System.currentTimeMillis();
        }
    }
}


