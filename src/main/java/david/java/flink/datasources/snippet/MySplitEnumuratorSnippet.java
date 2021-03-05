package david.java.flink.datasources.snippet;

import org.apache.flink.api.connector.source.SplitEnumerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:04 2021/3/2
 */
public class MySplitEnumuratorSnippet implements SplitEnumerator {

    private final long DISCOVER_INTERVAL = 60_000L;


    private List<MySplit> discoverSplits() {
        return new ArrayList<>();
    }

    @Override
    public void start() {

    }

    @Override
    public void handleSplitRequest(int i, @javax.annotation.Nullable String s) {

    }

    @Override
    public void addSplitsBack(List list, int i) {

    }

    @Override
    public void addReader(int i) {

    }

    @Override
    public Object snapshotState() throws Exception {
        return null;
    }

    @Override
    public void close() throws IOException {

    }

}

class MySplit {

}
