package david.java.practice.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @Author: David
 * @Date: Create in 下午7:57 2021/5/30
 */
public class LC_0169_majorityElement {

    /**
     * 题解:
     * 1. 利用hash 放到map
     * 2. 排序, 那么 第n/2 的位置肯定是 多数
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
            if (count + 1 > nums.length / 2) {
                return nums[i];
            }
        }

        //map 取出来, 排序第一个key 懒得弄了,在 for的if里,肯定返回了
        return 0;
    }
}
