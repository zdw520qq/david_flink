package david.java.practice.algorithm.leetcode;

/**
 * @Description: 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * @Author: David
 * @Date: Create in 下午4:52 2021/3/14
 */
public class LC_0009_isPalindrome {

    /**
     * 题解: 数字的话就不要转成字符串了
     * <p>
     * 思路一:
     * 数字翻转  将数字 对10 取余数, 原数字 /= 10, 新数字 = 余数 + 上一个新数字 * 10,
     * 其中要注意integer溢出的问题, 如果溢出了,那肯定就不是回文数字了, 然后比较值
     * <p>
     * <p>
     * 思路二:
     * 每次循环 原数字 /= 10
     * 既然是回文数字, 那么翻转一半的话, 前一半 == 后一半 是不是也可以了? 而且不用考虑溢出了
     * 那么如何判断到了 中间呢?
     * 偶数的话, 简单  原数字 == 新数字 即可 , 如果 原数字 < 新数字了, 肯定不是了
     * 奇数的话, 当 原数字 < 新数字 , 说明刚过 中间点, 那么 扣掉 新数字的末尾,  比较 新数字/10 == 原数字
     * <p>
     * 综合一下,   原数字 == 新数字  || 新数字/10 == 原数字  即可
     */
    public static boolean isPalindrome(int x) {


        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int num = 0;

        while (x > num) {
            int remainder = x % 10;
            num = num * 10 + remainder;
            x /= 10;
        }

        return x == num || x == num / 10;

    }

    public static void main(String[] args) {

        int i = 123211;
        System.out.println(isPalindrome(i));


    }

}
