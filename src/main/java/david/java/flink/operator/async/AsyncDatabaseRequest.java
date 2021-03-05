package david.java.flink.operator.async;


import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.AsyncDataStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.functions.async.ResultFuture;
import org.apache.flink.streaming.api.functions.async.RichAsyncFunction;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午6:02 2021/2/22
 */
public class AsyncDatabaseRequest extends RichAsyncFunction<String, Tuple2<String, String>> {

    private transient DatabaseClient client;

    @Override
    public void open(Configuration parameters) throws Exception {
        client = new DatabaseClient("host", "port", "credentials");
        super.open(parameters);
    }


    @Override
    public void close() throws Exception {
        client.close();
    }

    @Override
    public void asyncInvoke(String key, ResultFuture<Tuple2<String, String>> resultFuture) throws Exception {
        Future<String> result = client.query(key);

        CompletableFuture.supplyAsync(() -> {
            try {
                return result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return null;
            }
        }).thenAccept((String dbResult) -> {
            resultFuture.complete(Collections.singleton(new Tuple2<>(key, dbResult)));
        });
    }


    public static void main(String[] args) {
        DataStream<String> stream = null;

        /**
         * timeout: 指的是每次异步request不能超过1000 ms, 否则会认为是失败
         * capacity: 并行度, 需要注意的是一旦capacity耗尽的话,会触发背压机制
         */
        DataStream<Tuple2<String, String>> resultStream =
                AsyncDataStream.unorderedWait(stream, new AsyncDatabaseRequest(), 1000, TimeUnit.MILLISECONDS, 100);
    }
}

class DatabaseClient {
    String host;
    String port;
    String credentials;

    public DatabaseClient(String host, String port, String credentials) {
        this.host = host;
        this.port = port;
        this.credentials = credentials;
    }

    public void close() {
        //    nothing
    }

    public Future<String> query(String key) {
        return null;
    }


}
