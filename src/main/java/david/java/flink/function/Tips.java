package david.java.flink.function;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午6:37 2021/1/4
 */
public class Tips {

    /**
     * Min MinBy
     * min只返回计算的最小值，而最小值对应的其他数据不保证正确，返回元素的一部分，其他部分可能是其他元素的；
     * minBy返回计算的最小值，并且最小值对应的其他数据是保证正确的，返回整个元素
     *
     * window 与 windowAll
     * window可以作用在keyed的stream上，是并行的
     * windowAll 是把元素都装在一个窗口里，不是并行的，只会有一个task
     */


}
