package david.java.practice.algorithm.meituan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 对角线遍历
 * <p>
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * @Author: David
 * @Date: Create in 下午4:54 2021/5/20
 */
public class LC_0498_findDiagonalOrder {

    /**
     * 将矩阵 捏住左上,右下   拉伸成一条线, 那么 线的长度 是  两边之和-1
     * 基数向上,偶数 向下
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int step = 1;
        int sign = 1;
        int k = 0;
        int[] arr = new int[m * n];
        int i = 0, j = 0;

        int count = 0;
        while (i < m && j < n) {

            while (i >= 0 && i < m && j >= 0 && j < n) {
                arr[k++] = mat[i][j];
                i -= sign * step;
                j += sign * step;
            }

            count++;

            // 向右上
            if (sign > 0) {
                if (j < n) {
                    i = 0;
                } else {
                    j = n - 1;
                    i = count - n +1;
                }
            } else {
                if (i < m) {
                    j = 0;
                } else {
                    i = m - 1;
                    j = count - m +1;
                }
            }
            sign = -sign;
        }


        return arr;

    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonalOrder = findDiagonalOrder(ints);
        List<Integer> collect = Arrays.stream(diagonalOrder).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }
}
