package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * 
 *
 *
 * @Author: David
 * @Date: Create in 上午9:27 2021/5/17
 */
public class LC_0718_findLength extends DavidBase {
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums2.length + 1][nums1.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < nums2.length; i++) {
            dp[i][0] = 0;
        }

        int max = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == nums2[i]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] i1 = new int[]{1,2,3,2,1};
        int[] i2 = new int[]{3,2,1,4,7};
        int length = findLength(i1, i2);
        System.out.println(length);

    }
}
