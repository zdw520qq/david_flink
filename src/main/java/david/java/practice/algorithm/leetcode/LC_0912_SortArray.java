package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午10:33 2021/5/16
 */
public class LC_0912_SortArray extends DavidBase {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (nums == null || start == end) {
            return;
        }
        int pivot = nums[start];
        int l = start, r = end, p = l;

        while (l < r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            while (l < r && nums[l] < pivot) {
                l++;
            }
            if (l < r && nums[l] == nums[r]) {
                l++;
            }
            if (l < r && nums[l] > nums[r]) {
                swap(nums, l, r);
            }
        }

        if (l - 1 > start) {
            quickSort(nums, start, l-1);
        }
        if (l + 1 < end) {
            quickSort(nums, l + 1, end);
        }

    }

    public static void main(String[] args) {
        int[] inputArray = getInputArray();
        System.out.println(Arrays.stream(inputArray).boxed().collect(Collectors.toList()));
        int[] ints = sortArray(inputArray);
        System.out.println(Arrays.stream(ints).boxed().collect(Collectors.toList()));


    }

}
