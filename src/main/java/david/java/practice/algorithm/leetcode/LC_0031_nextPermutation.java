package david.java.practice.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 其实就是把他当成字符串, 然后比较,按字典排序比较, 找下一个紧挨着它的字符串
 * @Author: David
 * @Date: Create in 下午5:16 2021/4/27
 */
public class LC_0031_nextPermutation {

    /**
     * 题解:
     * 先重后向前, 找到第一个后面大于其前面的,  找到后,再找一个大于他的,且数最小的数, 交换, 然后, 这个数后面的在排序
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int index = 0;
        int minMax = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i]) {
                    flag = true;
                    if (nums[j] < minMax) {
                        minMax = nums[j];
                        index = j;
                    }
                }
            }
            if (flag) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }

        Arrays.sort(nums);
    }

    private static void sort(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = i; j - 1 >= start && j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // int[] ints = new int[]{4, 3, 2, 9, 6, 7, 8, 5, 1};
        int[] ints = new int[]{1, 3, 2};
        nextPermutation(ints);
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(collect);

    }
}
