package david.java.practice.algorithm.niuke;

/**
 * @Description: 合并两个有序的数组
 * <p>
 * 给出两个有序的整数数组 A 和 B，请将数组 B 合并到数组 A 中，变成一个有序的数组
 * 注意：
 * 可以假设 A 数组有足够的空间存放 B 数组的元素， A 和 B 中初始的元素数目分别为 m 和 n
 * @Author: David
 * @Date: Create in 下午11:04 2021/2/28
 */
public class NC22_merge2SortedArray {


    /**
     * 功能描述: 就是简单的归并排序
     */
    public static void merge(int A[], int m, int B[], int n) {
        int t = A.length - 1;
        while (m > 0 && n > 0) {
            A[t--] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        while (n > 0) {
            A[t--] = B[n-- -1];
        }
        while (m > 0) {
            A[t--] = A[m-- -1];
        }
    }


    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;

        int[] b = {0,2,4,6,8};

        merge(a, 5, b, 5 );

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }



    }
}
