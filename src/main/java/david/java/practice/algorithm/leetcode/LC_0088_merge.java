package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * @Author: David
 * @Date: Create in 上午9:02 2021/5/17
 */
public class LC_0088_merge extends DavidBase {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int i = nums1.length - 1, i1 = m - 1, i2 = n - 1;

        while (i1 >= 0 && i2 >= 0) {
            nums1[i--] = nums1[i1] <= nums2[i2] ? nums2[i2--] : nums1[i1--];
        }

        while (i1 >= 0) {
            nums1[i--] = nums1[i1--];
        }

        while (i2 >= 0) {
            nums1[i--] = nums2[i2--];
        }


    }

    public static void main(String[] args) {
        // int[] n1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] n1 = new int[]{2, 0};
        int[] n2 = new int[]{1};
        // int[] n2 = new int[]{2,5,6};
        merge(n1, 1, n2, 1);
        List<Integer> collect = Arrays.stream(n1).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }
}
