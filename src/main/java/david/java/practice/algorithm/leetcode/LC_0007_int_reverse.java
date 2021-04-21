package david.java.practice.algorithm.leetcode;

/**
 * @Description: 整数翻转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * @Author: David
 * @Date: Create in 上午11:07 2021/3/12
 */
public class LC_0007_int_reverse {

    /**
     * 功能描述: 题解
     *
     * 主要的难点在于防止integer溢出,每次添加的时候都要判断下, interger的最大值与最小值 / 10 后 与值对比的大小
     *
     * 计算逻辑, 数每次对10取余, 然后 新数 *= 10 然后加上余数
     *
     *
     * @param x
     * @return:
     */
    public int reverse(int x) {

        int rev = 0;

        if (x == 0) {
            return rev;
        }

        int positiveTail = Integer.MAX_VALUE % 10;
        int nagetiveTail = Integer.MIN_VALUE % 10;

        while (x != 0) {
            int remainder = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && remainder >= positiveTail)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && remainder <= nagetiveTail)) {
                return 0;
            }

            rev = rev * 10 + remainder;
        }

        return rev;
    }
}
