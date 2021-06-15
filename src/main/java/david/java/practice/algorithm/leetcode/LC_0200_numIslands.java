package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 * @Author: David
 * @Date: Create in 下午8:04 2021/6/3
 */
public class LC_0200_numIslands extends DavidBase {


    /**
     * 题解: 循环节点,  每个都递归, 直到 附近没有1为止, 同时, 递归到的节点 设为0 ,避免重复计算
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;

        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    recursive(grid, i, j);
                }
            }
        }
        return count;
    }


    private void recursive(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        //查找过,就设为0,避免陷入死循环
        grid[i][j] = '0';
        recursive(grid, i + 1, j);
        recursive(grid, i - 1, j);
        recursive(grid, i, j - 1);
        recursive(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        LC_0200_numIslands lc_0200_numIslands = new LC_0200_numIslands();
        int i = lc_0200_numIslands.numIslands(chars);
        System.out.println(i);
    }
}
