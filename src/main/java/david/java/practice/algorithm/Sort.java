package david.java.practice.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 常见排序算法
 * @Author: David
 * @Date: Create in 下午7:54 2021/1/24
 */
public class Sort {

    // public static void main(String[] args) {
    //     int[] input1 = getInput();
    //     List<Integer> integers = bubbleSort(input1);
    //     System.out.println(integers);
    //
    //
    // }

    private static int[] getInput() {
        return new int[]{3, 1, 2, 4, 7, 5, 6, 8};
    }

    /**
     * *************************** 1. 冒泡排序 *************************************
     *
     * @param input
     * @return
     */
    public static List<Integer> bubbleSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int tmp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = tmp;
                }
            }
        }

        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }

    /**
     * *************************** 2. 快速排序 *************************************
     * <p>
     * 主要思路是, 把第一个值作为基准点, 比基准点大的都放到右边,比基准点小的都放到左边, 这样就好理解了,
     * 基准点在左边则右边--, 基准点在右边,则左边++ pivot把数组分成2部分, pivot为中间值,
     *
     * 需要注意的地方:
     * 因为是为了把数组分为两部分,所以, 比pivot小的在左边, 大的在右边,那么 还有就是等于pivot的数, 只能放在一边, 或左,或右,
     * 即要考虑三种情况  > = <, 因为pivot的值在不停的交换,所以 要么pivot 的下标是 l  要么是r ,所以,  ==条件也就是  input[l] = input[r]
     *
     * @param input
     * @return
     */
    public static void quickSort(int[] input, int begin, int end) {
        if (input == null || input.length == 1) {
            return;
        }
        if (begin >= end) {
            return;
        }
        //pivot一直不变
        int pivot = input[begin];
        int b = begin;
        int e = end;
        while (b < e) {
            // 注意条件里pivot不能 == input[e||b], 因为,比如pivot在右边, 那它肯定==input[e],
            // 这时,肯定不能e--, 因为此时是b在移动
            while (b < e && pivot < input[e]) {
                e--;
            }
            // pivot 与 input[b] 比较的前提是,已经交换过一次了,pivot在右边
            while (b < e && pivot > input[b]) {
                b++;
            }

            // 这里是 input[b||e] == pivot 的情况, 因为pivot 肯定为 input[b] 或input[e],
            // 所以就用input[b] == input[e]好了, 为了方便, 只要相对就 b++ 或者 e-- 就行了,
            // 放心,pivot记录了基准值,不会变
            if (b < e && input[b] == input[e]) {
                b++;
            }

            // 当左边> 右边那肯定是要交换的, 而且此时 pivot 不是在 b 上, 就是在在 e上
            if (b < e && input[b] > input[e]) {
                int tmp = input[b];
                input[b] = input[e];
                input[e] = tmp;
            }
        }
        // 当 b=e 说明pivot已经经数据分割好了,开始下一轮,两边数组的分割了, b不需要动, 已经固定了
        if (b - 1 > begin) {
            quickSort(input, begin, b - 1);
        }
        if (b + 1 < end) {
            quickSort(input, b + 1, end);
        }
    }


    /**
     * *************************** 3. 堆排序 *************************************
     *
     * @param data
     */
    public static void heepSort(int[] data) {
        build(data, data.length);
        for (int i = data.length - 1; i > 0; i--) {
            int t = data[i];
            data[i] = data[0];
            data[0] = t;
            build(data, i);
        }
    }

    /**
     * 构建堆, 节点为k, 默认k=data.length
     *
     * @param data
     */
    private static void build(int[] data, int k) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            adjustHeap(data, i, k);
        }
    }

    /**
     * @param data 数组
     * @param i    准备与子节点比对交换的节点
     * @param k    默认 k = data.length, 即对所有数据进行构建堆,
     *             当k < data.length的时候代表要构建的堆是数组的一部分,
     *             比如求 头尾交换之后, 的部分不需要
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


    /**
     * *************************** 4. 选择排序 *************************************
     * <p>
     * 也是两个for循环, 不过每次记录最小的下标, 然后交换即可
     *
     * @param arr
     * @return
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }


    /**
     * *************************** 5. 插入排序 *************************************
     * <p>
     * 看做一个一个的向队列里插入, 在插入的时候就排序
     * 第二个for,的目的是从第一个for的i开始向前比较, 如果 arr[j] > arr[j-1] 就没必要比了,直接break
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //j >0见说明, j--
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    /**
     * *************************** 6. 归并排序 *************************************
     *
     * @param arr
     */
    public static int[] mergeSort(int[] arr, int begin, int end) {
        if (arr == null) {
            return arr;
        }
        if (begin == end) {
            return new int[]{arr[begin]};
        }
        int mid = (begin + end) / 2;
        int[] left = mergeSort(arr, begin, mid);
        int[] right = mergeSort(arr, mid + 1, end);
        int[] newArr = new int[left.length + right.length];

        int l = 0, r = 0, n = 0;
        while (l < left.length && r < right.length) {
            newArr[n++] = left[l] > right[r] ? right[r++] : left[l++];
        }
        while (l < left.length) {
            newArr[n++] = left[l++];
        }
        while (r < right.length) {
            newArr[n++] = right[r++];
        }

        return newArr;
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) throws Exception {
        int arr[] = {6, 5, 2, 7, 3, 1, 9, 8, 4, 9};
        // System.out.print("堆排序结果：");
        // heepSort(arr);
        // selectSort(arr);
        // insertSort(arr);
        quickSort(arr, 0, arr.length - 1);
        // arr = mergeSort(arr, 0, arr.length - 1);

        for (int m : arr) {
            System.out.print(m + " ");
        }


    }
}
