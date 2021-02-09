package david.java.practice.algorithm.niuke;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:  做着做着坐反了做成求最小值了,不过无所谓,就这样吧, 懒得改了
 *
 * 思路: 构建一个堆, 求最大值构建一个为k的最小堆, 第k+1 个数与 heap[0] 进行比较,如果>data[0], 则交换data[k+1] 与data[0],然后调整heap
 * 然后进行 k+2 个数的比较
 * @Author: David
 * @Date: Create in 下午7:10 2021/1/24
 */
public class NC119_GetLeastNumber {
    public static void main(String[] args) {
        int[] data = {5, 6, 4, 7, 1, 9, 3, 0, 12, 76, 23, 14, 14, 32, 54};
        System.out.println(data.length);




        heepSort(data, 12);

        List<Integer> collect = Arrays.stream(data).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 构建堆, 节点为k, 默认k=data.length
     * @param data
     */
    private static void build(int[] data, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(data, i, k);
        }
    }

    /**
     * 堆排序, 求前k个最小值, 默认k=data.length
     * 求最小值要构建最大堆, 求最大堆要构建最小堆
     *
     * @param data
     */
    private static void heepSort(int[] data, int k) {
        build(data, k);
        for(int i = k; i < data.length; i++) {
            if (data[i] < data[0]) {
                int t = data[0];
                data[0] = data[i];
                data[i] = t;
                adjustHeap(data, 0, k);
            }
        }
    }




    /**
     *
     * @param data 数组
     * @param i 准备与子节点比对交换的节点
     * @param k 默认 k = data.length, 即对所有数据进行构建堆, 当k < data.length的时候代表要构建的堆是数组的一部分,比如求 前k的最大值
     */
    private static void adjustHeap(int[] data, int i, int k) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        //用来标记与哪个交换;
        int largest = i;
        // 没有子节点了,就不需要比较了
        if (l >= k) {
            return;
        }

        int bigChildIndex = r >= k ? l : data[l] >= data[r] ? l : r;

        if (data[i] < data[bigChildIndex]) {
            largest = bigChildIndex;
        }

        if (largest != i) {
            int tmp = data[i];
            data[i] = data[largest];
            data[largest] = tmp;
            adjustHeap(data, largest, k);
        }
    }
}
