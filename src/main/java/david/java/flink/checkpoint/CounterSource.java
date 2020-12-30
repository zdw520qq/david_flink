package david.java.flink.checkpoint;

import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.common.typeutils.base.LongSerializer;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午2:09 2020/12/22
 */
public class CounterSource extends RichParallelSourceFunction<Long> implements CheckpointedFunction {
    private Long offset = 0L;
    private volatile boolean isRunning = true;
    private ListState<Long> state;

    @Override
    public void run(SourceContext<Long> ctx) throws Exception {
        final Object lock = ctx.getCheckpointLock();
        while (isRunning) {
            synchronized (lock) {
                ctx.collect(offset);
                offset += 1;
            }
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }

    @Override
    public void initializeState(FunctionInitializationContext context) throws Exception {
        state = context.getOperatorStateStore().getListState(
                new ListStateDescriptor<>(
                        "state",
                        LongSerializer.INSTANCE
                )
        );

        for (Long l : state.get()) {
            offset = l;
        }
    }

    @Override
    public void snapshotState(FunctionSnapshotContext functionSnapshotContext) throws Exception {
        state.clear();
        state.add(offset);
    }
}
