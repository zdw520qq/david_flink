package david.java.practice.algorithm.niuke;

/**
 * @Description: 子数组的最大累加和的问题
 * <p>
 * 题目描述
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * @Author: David
 * @Date: Create in 下午11:42 2021/2/22
 */
public class NC19_subArraySum {


    /**
     * 解题思路:
     * 这道题的难点是, 从什么地方开始截取数组, 截取早了,可能中间会有负数导致结果变小, 截取晚了, 可能前面的数字加起来是>0的, 导致累加不上
     * 根据题目肯定有>=0的数,所以如果前面之和 <0, 直接舍弃吧,记为0就行, sum记录累加值, 用maxsum 记录累加过程中出现过的最大值
     *
     * @param arr
     * @return
     */
    public int maxsumofSubarray(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;
                continue;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


}
