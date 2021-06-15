package david.java.practice.algorithm.leetcode;

/**
 * @Description: 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @Author: David
 * @Date: Create in 下午4:00 2021/6/1
 */
public class LC_0136_singleNumber {


    /**
     * 题解:
     * 答案是使用位运算。对于这道题，可使用异或运算 ⊕。异或运算有以下三个性质。
     * <p>
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a ^ a=0。
     * 异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a)= b ^ 0 = b。
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_0136_singleNumber fun = new LC_0136_singleNumber();
        int[] arr = {1,2,3,4,3,2,1};
        int i = fun.singleNumber(arr);
        System.out.println(i);
    }
}
