package david.java.practice.algorithm.leetcode;

/**
 * @Description: 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * @Author: David
 * @Date: Create in 下午8:59 2021/3/21
 */
public class LC_0012_intoRoma {

    /**
     * 题解: 贪心算法
     * 首先要有一个字典表,存储题目给定的罗马和数字的对应关系, 尤其是别忘了 4, 9 这种特殊的
     *
     * 然后用给定的数字与number里面最大的值比较,即第一个,
     * 如果 < number[i], 则i++, 比较number里面的下一个,
     * 如果 > number[i], 在stringbuilder append其对应的罗马数字, 同时,数字 -= number[i]
     *
     */
    public static String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < numbers.length && num >= 0) {
            if (num >= numbers[i]) {
                sb.append(romans[i]);
                num = num - numbers[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = intToRoman(888);
        System.out.println(s);
    }
}
