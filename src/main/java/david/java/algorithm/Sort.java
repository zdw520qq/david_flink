package david.java.algorithm;

import scala.Int;

import java.util.ArrayList;
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
     * 冒泡排序
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
     * @param input
     * @return
     */
    public static List<Integer> quickSort(int[] input) {
        return null;
    }


    // /**
    //  * 堆排序
    //  * @param n 待排序数组
    //  */
    // public static void heapsort(int n[]) {
    //     for (int i = n.length - 1; i >= 1; i--) {
    //         buildHeap(n, i);
    //         swap(n, 0, i);
    //     }
    // }
    //
    // /**
    //  * @param n   待排序数组
    //  * @param end 待排序数组末位下标
    //  */
    // public static void buildHeap(int n[], int end) {
    //     int len = end + 1;
    //     for (int i = len / 2 - 1; i >= 0; i--) {
    //         //堆中i节点对应的左右子节点l和r
    //         int l = 2 * i + 1, r = l + 1;
    //         //指向较大数节点的指针
    //         int p = l;
    //         if (r <= len - 1 && n[l] < n[r]) {
    //             p = r;
    //         }
    //         if (n[i] < n[p]) {
    //             swap(n, i, p);
    //         }
    //     }
    // }

    // /**
    //  * @param n 待排序数组
    //  * @param i 待交换数字数组下标
    //  * @param j 待交换数字数组下标
    //  */
    // private static void swap(int n[], int i, int j) {
    //     n[i] ^= n[j];
    //     n[j] ^= n[i];
    //     n[i] ^= n[j];
    // }

    public static int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) throws Exception {
        int n[] = {6, 5, 2, 7, 3, 9, 8};
        sort(n);
        System.out.print("堆排序结果：");
        for (int m : n) {
            System.out.print(m + " ");
        }
    }
}
