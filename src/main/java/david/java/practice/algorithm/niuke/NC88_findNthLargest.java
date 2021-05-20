package david.java.practice.algorithm.niuke;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午8:29 2021/2/20
 */
public class NC88_findNthLargest extends DavidBase {

    public static int findKth(int[] a, int n, int K) {
        return quickFindK(a, 0, n-1, K - 1);
    }

    private static int quickFindK(int[] a, int begin, int end, int k) {
        int pivot = a[begin];
        int b = begin;
        int e = end;

        while (b < e) {
            while (b < e && a[b] > pivot) {
                b++;
            }
            while (b<e && a[e] < pivot) {
                e--;
            }
            if (b<e && a[b] == a[e]) {
                b ++;
            }
            if (b<e && a[b] < a[e]) {
                swap(a, b ,e);
            }
        }
        if (b == k) {
            return a[b];
        }

        if (b > k) {
            return quickFindK(a, begin, b-1, k);
        }

        return quickFindK(a, b+1, end, k);
    }

    public static void main(String[] args) {
        int[] input = getInputArray();
        int kth = findKth(input, 10, 10);
        System.out.println("input =======");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        System.out.println(kth);
    }
}
