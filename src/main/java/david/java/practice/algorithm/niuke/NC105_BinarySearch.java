package david.java.practice.algorithm.niuke;

/**
 * @Description: 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 * @Author: David
 * @Date: Create in 下午11:10 2021/1/10
 */
public class NC105_BinarySearch {

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_(int n, int v, int[] a) {

        int start = 0;
        int end = n - 1;
        int middle;

        if (n == 0 || a[start] > v) {
            return 1;
        }

        if (a[end] < v) {
            return n + 1;
        }

        while (start <= end) {
            middle = (start + end) / 2;
            if (a[middle] < v) {
                start = middle + 1;
            } else if (a[middle] > v) {
                end = middle - 1;
            } else {
                while (a[middle - 1] == v) {
                    middle = middle - 1;
                }
                return middle + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        // int[] data = new int[]{1,2,4,4,5};
        int[] data = new int[]{1, 1, 2, 3, 7, 7, 7, 9, 9, 10};
        int i = upper_bound_(10, 2, data);
        System.out.println(i);
    }

}
