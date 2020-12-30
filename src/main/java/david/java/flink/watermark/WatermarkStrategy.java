package david.java.flink.watermark;

import org.apache.flink.api.common.eventtime.TimestampAssigner;
import org.apache.flink.api.common.eventtime.TimestampAssignerSupplier;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkGeneratorSupplier;

/**
 * @Description: flink api 需要一个watermark策略,包含 timestampAssigner和watermarkGenerator
 * @Author: Zhaodawei
 * @Date: Create in 下午2:41 2020/12/18
 */
public class WatermarkStrategy<T> implements TimestampAssignerSupplier<T>, WatermarkGeneratorSupplier<T> {

    @Override
    public WatermarkGenerator<T> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
        return null;
    }

    @Override
    public TimestampAssigner<T> createTimestampAssigner(TimestampAssignerSupplier.Context context) {
        return null;
    }


}


