package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * @Author: David
 * @Date: Create in 上午11:14 2021/6/15
 */
public class LC_0034_searchRange extends DavidBase {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1;
        int mid = 0;
        int pStart = start, pEnd = end;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                pEnd = end;
                end = mid - 1;
            } else if (nums[mid] < target) {
                pStart = start;
                start = mid + 1;
            } else {
                break;
            }
        }

        if (start > end) {
            return new int[]{-1, -1};
        }


        int lIndex = mid;
        int rIndex = mid;

        int hit;
        int left = pStart, right = mid - 1;
        while (left <= right) {
            hit = (left + right) / 2;
            if (nums[hit] < target) {
                left = hit + 1;
            } else {
                lIndex = hit;
                right = hit - 1;
            }
        }


        left = mid + 1;
        right = pEnd;
        while (left <= right) {
            hit = (left + right) / 2;
            if (nums[hit] > target) {
                right = hit - 1;
            } else {
                rIndex = hit;
                left = hit + 1;
            }
        }

        return new int[]{lIndex, rIndex};
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5,9};
        // int[] arr = {5,7,7,8,8,10};
        int target = 3;

        LC_0034_searchRange ll = new LC_0034_searchRange();
        int[] ints = ll.searchRange(arr, target);
        printArr(ints);

    }
}
