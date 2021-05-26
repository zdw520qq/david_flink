package david.java.practice.algorithm.zijie;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:  最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 * @Author: David
 * @Date: Create in 下午8:53 2021/5/24
 */
public class LC_0053_maxSubArray extends DavidBase {

    /**
     * 题解: 如果 一个数 > 这个数到之前 累计的和 , 那你觉得之前的数还需要么?
     */
    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            preSum = Math.max(nums[i], preSum + nums[i]);
            maxSum = Math.max(maxSum, preSum);
        }

        return  maxSum;
    }
}
