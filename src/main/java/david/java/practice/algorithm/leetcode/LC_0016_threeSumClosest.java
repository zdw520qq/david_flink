package david.java.practice.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Description:
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * @Author: David
 * @Date: Create in 下午4:01 2021/3/23
 */
public class LC_0016_threeSumClosest {
    /**
     * 题解:
     * 与上题类似,也需要 对数据集进行sort
     * 指定第一个数为first, 这个是最外层的循环
     * second在最左, third在最右,
     * 三数相加, 比target小则 second 的index++, 比target大则 third 的index-- , 距离最近时候的(三数之和-target  的绝对值), 的最优的值
     *
     *
     */
    public static int threeSumClosest(int[] nums, int target) {
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int first = 0; first < nums.length - 1; first++) {
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (Math.abs(best - target) - Math.abs(sum - target) > 0) {
                    best = sum;
                }
                if (sum == target) {
                    return sum;
                }

                if (sum - target >= 0) {
                    third--;
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else {
                    second++;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                }
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-1, 2, 1, -4};

        int[] data1 = new int[]{4, -1, -4, 4};
        int i = threeSumClosest(data1, -1);
        System.out.println(i);
    }
}
