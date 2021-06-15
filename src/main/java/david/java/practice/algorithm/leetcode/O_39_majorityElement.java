package david.java.practice.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @Author: David
 * @Date: Create in 下午5:07 2021/6/11
 */
public class O_39_majorityElement {

    /**
     * 题解:排序后,在中间的肯定是 超过一半的
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList.poll());
        // System.out.println(linkedList.pop());
    }






}
