package david.java.practice.algorithm.leetcode;

/**
 * @Description: 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * ************************************
 * 题解:
 * http://note.youdao.com/s/WkA7y9Nz
 * ************************************
 * @Author: David
 * @Date: Create in 下午9:39 2021/3/6
 */
public class LC_0004_findMedianSortedArrays {
    /**
     * 题解:
     * 因为两个数组都是有序的, 吧两个数组摞在一起, 然后一刀切开, 肯定会有一刀 把这摞起来的数组分为两部分, 左边的都小于右边, 利用二分法来切割
     *
     * 切的时候可以从上排的中间开始切, 下面的切点的位置是可以计算出来的
     *
     * 切割后满足左边都<右边, 因为每行都是有序的, a2< a3, b2 <b3, 所以简化为  a2<b3 && b2< a3
     *
     * a1 a2 | a3 a4
     * b1 b2 | b3 b4
     *
     *
     *
     *
     * @param nums1
     * @param nums2
     * @return:
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 为了方便切割, 将段数组放在上面, 在这里体现为第一个
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;


        // 另i为上层数组切割后左边的个数, 那么切割线左边的下标为 i-1, 右边的下标为i
        // 让切割线先从上层的中间开始
        int i = (m + 1) / 2;

        // 因为上下两层左边总共个数是, + 1 是为了防止是奇数个,保证左边数量 =右边 或 右边 + 1
        int totalLeft = (m + n + 1) / 2;
        // 那么这样的话,下层左边的个数是 j = totalLeft - i;
        int j = totalLeft - i;

        int start = 0;
        int end = m;

        int lu;
        int ru;
        int ld;
        int rd;

        while (true) {
            // 此时切割线在上层数组的最左边, 为了下面比较方便, 直接这最小值就行了
            lu = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            // 此时切割线在上层数组的最右边, 为了下面比较方便, 直接这最大值就行了
            ru = i == m ? Integer.MAX_VALUE : nums1[i];

            ld = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];

            rd = j == n ? Integer.MAX_VALUE : nums2[j];

            // 满足这个条件的时候就是成功分开了 左边和右边
            if (lu <= rd && ld <= ru) {
                break;
            }

            // 下面对 第一排的数组 进行二分法
            if (lu > rd) {
                end = i - 1;
            }

            if (ld > ru) {
                start = i + 1;
            }

            i = (start + end + 1) / 2;
            j = totalLeft - i;
        }

        int leftMax = Math.max(lu, ld);
        int rightMin = Math.min(ru, rd);

        if ((m + n) % 2 == 1) {
            return leftMax;
        } else {
            return (leftMax + rightMin) / 2d;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int[] a1 = new int[]{3, 8, 9, 10};
        int[] a2 = new int[]{2, 4, 6, 12, 18, 20};

        double medianSortedArrays = findMedianSortedArrays(a1, a2);
        System.out.println(medianSortedArrays);
    }


}
