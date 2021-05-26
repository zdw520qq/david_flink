package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午4:24 2021/5/17
 */
public class LC_0215_findKthLargest extends DavidBase {

    public static int findKthLargest(int[] nums, int k) {
       return  quickFindK(nums, 0, nums.length - 1, k);
    }

    private static int quickFindK(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int s = start;
        int e = end;
        while (s < e) {
            while (s < e && nums[e] < pivot) {
                e--;
            }
            while (s < e && nums[s] > pivot) {
                s ++;
            }
            if (s < e && nums[s] == nums[e]) {
                s ++;
            }
            if (s < e && nums[s] < nums[e]) {
                swap(nums, e, s);
            }
        }
        if (s+1  == k) {
            return nums[s];
        } else if (s+1 > k) {
            return quickFindK(nums, start, s - 1, k);
        } else  {
            return quickFindK(nums, s + 1, end, k);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(arr, 2);
        System.out.println(kthLargest);
    }
}
