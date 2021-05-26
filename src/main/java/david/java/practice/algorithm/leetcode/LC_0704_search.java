package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:  二分法
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @Author: David
 * @Date: Create in 上午9:55 2021/5/17
 */
public class LC_0704_search extends DavidBase {

    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        while(s <= e) {
            int mid = (s + e) /2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                e = mid -1;
            } else {
                s = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{-1,0,3,5,9,12};

        int search = search(inputArray, 2);
        System.out.println(search);
    }

}
