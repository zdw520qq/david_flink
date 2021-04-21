package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.Base;

import java.util.HashMap;

/**
 * @Description: 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @Author: David
 * @Date: Create in 下午6:16 2021/3/6
 */
public class LC_0001_twoNumSum extends Base {

    /**
     * 功能描述: 转为已知一个数a, 求 target-a 在不在
     * 定义一个map<value, index>, 看map是否包含target-a, 如果不包含就放入map
     * 一个for即可完成, 因为 比如 a + b = target, 当for指针在a时, b还没到, 那就 map.put(a, index), 当for的指针到了b的时候,因为
     * a 在map里面, 就查到了.
     *
     * @param nums
     * @param target
     * @param nums
     * @param target
     * @return:
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(arr, 9);
        printArr(ints);
    }


}
