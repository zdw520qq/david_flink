package david.java.flink.pojo;

/**
 * @Description:
 * @Author: Zhaodawei
 * @Date: Create in 下午5:44 2020/12/18
 */
public class MyEvent {

    public boolean hasWatermarkMarker() {
        return true;
    }

    public long getWatermarkTimestamp() {
        return System.currentTimeMillis();
    }
}
