package david.java.practice.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * @Author: David
 * @Date: Create in 下午3:17 2021/3/23
 */
public class LC_0015_threeSum {

    /**
     * 题解: 题解有些类似于两数之和, 也要用到双指针法
     * 1. 第一步,要排序这个数组, 这样利于找出重复的数字
     * 2. 设置一个target, 这个target在sorted后的数组里面, 从左到右依次轮过, 但是注意下, target的数与上一个target是否相等,
     * 如果相等,continue, 设置下一个数为target
     * 3. 双指针初始化在数组的头尾, 两数相加与target比较, > target 则 right --, < target 则 left ++ , ==target则加入结果集,
     * 在过程中同样需要注意的是, 指针在移动的时候, 如果与上一个相同, 则,指针继续移动,避免重复
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        if (nums[0] > 0) {
            return ans;
        }

        // first 为target  second 与 target 的和 = -first, 需要注意的是防止 [0,0,0]这种情况,
        // 要去重,其实, 在first 右移的时候, 如果  first[i] == first[i-1] ,那就直接 continue, second 也同理,就可以去重了
        for (int first = 0; first < nums.length - 1; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                if (nums[second] + nums[third] == -nums[first]) {
                    //加进去后, 让second 向右, third向左, 继续判断后面是不是还有符合要求的
                    ans.add(Arrays.asList(nums[first], nums[second++], nums[third--]));

                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }

                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                }

                if (second < third && nums[second] + nums[third] + nums[first] > 0) {
                    third--;
                }

                if (second < third && nums[second] + nums[third] + nums[first] < 0) {
                    second++;
                }


            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-1, 0, 1, 2, -1, -4};
        int[] data1 = new int[]{0, 0, 0, 0,};
        int[] data2 = new int[]{-2, 0, 1, 1, 2};

        List<List<Integer>> lists = threeSum(data2);
        System.out.println(lists);

    }
}