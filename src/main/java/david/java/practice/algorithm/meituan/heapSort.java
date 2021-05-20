package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:36 2021/5/17
 */
public class heapSort extends DavidBase {


    public static void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            build(nums, nums.length - i);
            swap(nums, 0, nums.length -1 -i);
        }

    }


    private static void build(int[] nums, int k) {
        for (int j = (k - 1) / 2; j >= 0; j--) {
            adjust(nums, j, k);
        }
    }

    private static void adjust(int[] nums, int i, int k) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //没有子节点了
        if (left >= k) {
            return;
        }
        // right >= k  只有左,  right < k 左右都有
        int biggerChild = right >= k ? left : nums[left] > nums[right] ? right : left;

        if (nums[i] > nums[biggerChild]) {
            swap(nums, i, biggerChild);
        }

        adjust(nums, biggerChild, k);
    }

    public static void main(String[] args) {
        int[] inputArray = getInputArray();
        System.out.println(arr2List(inputArray));

        heapSort(inputArray);
        System.out.println(arr2List(inputArray));

    }

}
