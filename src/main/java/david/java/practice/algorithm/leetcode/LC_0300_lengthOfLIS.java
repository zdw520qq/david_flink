package david.java.practice.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Description: 长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * @Author: David
 * @Date: Create in 下午12:29 2021/6/6
 */
public class LC_0300_lengthOfLIS {

    /**
     * 题解: 动态规划
     * 要计算  dp[i], 需要  在[0, i-1] 找到 < nums[i] 的数, 然后 Max[ dp[0] 到 dp[i-1] ] + 1
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            // 找dp[i-1], 找 i 之前最大的
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6};

        LC_0300_lengthOfLIS lc_0300_lengthOfLIS = new LC_0300_lengthOfLIS();
        int i = lc_0300_lengthOfLIS.lengthOfLIS(arr);
        System.out.println(i);

    }
}
