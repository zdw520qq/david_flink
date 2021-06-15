package david.java.practice.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？
 * 找出所有满足条件且不重复的四元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[]
 * @Author: David
 * @Date: Create in 下午9:13 2021/4/18
 */
public class LC_0018_foursum {

    /**
     * 题解: 依旧是先排序,然后双指真法, a < b < c < d ,  让c 和 d 进行双指针
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        //,此层为a, 最右侧要留3个
        for (int i = 0; i < nums.length - 3; i++) {
            //这里是 >0,防止数组越界
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //这种情况已经是最小的了
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //这中情况是最大了
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }

            //此层为b
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 注意这里是i+1
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //这种情况已经是最小的了
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //这中情况是最大了
                if (nums[i] + +nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {

                    while (l < r && nums[l] + nums[r] + nums[i] + nums[j] > target) {
                        r--;
                    }
                    while (l < r && nums[l] + nums[r] + nums[i] + nums[j] < target) {
                        l++;
                    }
                    if (l < r && nums[l] + nums[r] + nums[i] + nums[j] == target) {
                        ArrayList<Integer> integers = new ArrayList<>((Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        result.add(integers);
                        l++;

                    }
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && r < nums.length - 1 && nums[r] == nums[l + 1]) {
                        r--;
                    }

                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = {0,0,0,0};
        List<List<Integer>> lists = fourSum(ints, 0);
    }

}
