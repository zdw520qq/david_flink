package david.java.practice.algorithm.leetcode;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午10:48 2021/3/23
 */
public class LC_0013_roman2int {


    /**
     * 题解:
     * 此题与上一题类似,都先要将对应字典表列出来, 本题的难度在用如何 解决 9, 4 这种数
     * 从右到左遍历罗马数字, 也就是从小到大遍历罗马数字
     * 记录上一个循环时候的罗马数字是什么,
     * 当 本次的罗马对应的数字 >= 上一个的时候, value += 罗马对应的数字
     * 如果 本次的罗马数字 < 上一个的时候, 那就是4或9 的情况了,   value -= 罗马对应的数字
     *
     *
     */
    public static int romanToInt(String s) {

        char[] chars = s.toCharArray();
        int value = 0;
        int preRoman = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            int curRoman = convert(chars[i]);
            value = curRoman >= preRoman ? value + curRoman : value - curRoman;
            preRoman = curRoman;
        }

        return value;
    }

    public static int convert(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }


    public static void main(String[] args) {
        String roman = "MCMXCIV";
        int i = romanToInt(roman);
        System.out.println(i);
    }
}
