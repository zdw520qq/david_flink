package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * @Author: David
 * @Date: Create in 下午3:50 2021/5/28
 */
public class LC_0054_spiralOrder extends DavidBase {


    // 一层一层的循环
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        // 左上, 右上,
        // 左下, 右下
        // 一圈 一圈遍历
        int wideBegin = 0, wide = matrix[0].length - 1;
        int highBegin = 0, high = matrix.length - 1;
        while (wideBegin <= wide && highBegin <= high) {

            for (int i = wideBegin; i <= wide; i++) {
                list.add(matrix[wideBegin][i]);
            }
            for (int i = highBegin + 1; i <= high; i++) {
                list.add(matrix[i][wide]);
            }

            if (highBegin < high) {
                for (int i = wide - 1; i >= wideBegin; i--) {
                    list.add(matrix[high][i]);
                }
            }
            if (wideBegin < wide) {
                for (int i = high - 1; i > highBegin; i--) {
                    list.add(matrix[i][wideBegin]);
                }
            }
            wideBegin++;
            highBegin++;
            wide--;
            high--;
        }

        return list;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int total = matrix.length * matrix[0].length;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // turn 为 0 ~ 3  即4个值
        int turn = 0;
        // 四个拐点
        int lu = 0, ru = matrix[0].length, rd = matrix.length, ld = 0;
        int[] step = direction[0];

        int i = 0, j = 0;

        for (int k = 0; k < total; k++) {
            list.add(matrix[i][j]);

            if (i + step[0] < lu || i + step[0] >= ld || j + step[1] < ru || j + step[1] >= rd) {
                turn++;
                step = direction[turn % 4];
                switch (turn % 4) {
                    case 0: {
                        ld++;
                        continue;
                    }
                    case 1: {
                        lu++;

                        continue;

                    }
                    case 2: {
                        ru--;
                        continue;

                    }
                    case 3: {
                        lu--;
                        continue;

                    }
                    default: {

                    }
                }
            }

            i += step[0];
            j += step[1];


        }

        return list;
    }
    //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]

    public static void main(String[] args) {
        // int[][] data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7,8, 9}};
        int[][] data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        List<Integer> integers = spiralOrder(data);
        System.out.println(integers);

    }
}
