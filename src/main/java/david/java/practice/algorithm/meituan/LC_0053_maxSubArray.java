package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * @Author: David
 * @Date: Create in 下午2:21 2021/5/17
 */
public class LC_0053_maxSubArray extends DavidBase {

    /**
     * 题解: 状态转移方程: max = Math.max(preMax + nums[i], nums[i])
     * 即, 当n = i 的时候, 如果 sum[0, i-1] < 0,  那么, max = nums[i]
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum < 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }


}
