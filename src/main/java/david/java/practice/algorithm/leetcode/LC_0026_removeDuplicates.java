package david.java.practice.algorithm.leetcode;

/**
 * @Description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * @Author: David
 * @Date: Create in 下午3:43 2021/4/25
 */
public class LC_0026_removeDuplicates {


    /**
     * 题解:这个题叙述的不严谨啊,数据怎么删除呢?长度的是固定的啊,我当时是卡在这了,后来看了下官方题解,特么的, 这哪叫删除啊 擦
     * 用了双指针, left != right  的时候left++,   每次right 一直++
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int left = 1, right = 1;
        while (right <= nums.length) {
            if (nums[left - 1] != nums[right - 1]) {
                left++;
                nums[left-1] = nums[right - 1];
            }
            right++;
        }
        return left;
    }

}
