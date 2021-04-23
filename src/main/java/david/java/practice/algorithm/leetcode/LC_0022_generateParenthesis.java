package david.java.practice.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * @Author: David
 * @Date: Create in 下午3:54 2021/4/22
 */
public class LC_0022_generateParenthesis {

    /**
     * 题解: (看第二种吧, 这个主要是为了练写递归)
     * 第一种方法,先穷举出所有的排列,然后在判断排除
     * <p>
     * 排除的方法是, 定义一个 balance = 0, '(' 则 balance ++,  ')' 则balance--, 在过程中如果 balance <0 可以直接停止了
     * 因为, ')' 的左边必须有个 '(', 最后 还有balance == 0
     */
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        recursiveAll(n, new char[n * 2], 0, list);
        return list;
    }

    /**
     * 我最开是没注意, 没有用positon和 char[]数组, 而是用了 stringbuilder, 在递归的时候去append.
     * 结果错了,是因为 在注释为1 的地方, sb.append 后, 在sb的时候又 append了
     * 其实,这两个应该是独立的,因为他们在递归的同一层, 二用sb.append后, 本来第1层只应该有1个, 但是在 注释2的时候又append了,到时第一层有了2个
     * 所以,这里用了数组, 在注释2 的地方, 直接把上一个地方 给覆盖
     */
    private static void recursiveAll(int n, char[] s, int position, List<String> list) {
        if (position == 2 * n) {
            if (isValid(s)) {
                list.add(new String(s));
            }
            return;
        }
        s[position] = '(';
        // 1
        recursiveAll(n, s, position + 1, list);
        s[position] = ')';
        // 2
        recursiveAll(n, s, position + 1, list);
    }

    /**
     * 判断字符串是不是符合要求:
     */
    private static boolean isValid(char[] chars) {
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    /**
     * 题解:
     * 第二种方法, 一边检查,一边穷举, 最后到了指定长度的就是合格的
     * 检查的时候也是利用balance, 每次递归的时候记住balance, 如果<0 就直接舍弃
     */
    public static List<String> generateParenthesisOptimization(int n) {
        ArrayList<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        recursiveOptimization(n, new char[n * 2], 0, 0, list);
        return list;
    }

    private static void recursiveOptimization(int n, char[] chars, int position, int balance, List<String> list) {
        if (balance < 0) {
            return;
        }
        if (position == 2 * n) {
            if (balance == 0) {
                list.add(String.valueOf(chars));
            }
            return;
        }
        chars[position] = '(';
        recursiveOptimization(n, chars, position + 1, balance + 1, list);
        chars[position] = ')';
        recursiveOptimization(n, chars, position + 1, balance - 1, list);


    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);

        List<String> strings1 = generateParenthesisOptimization(3);
        System.out.println(strings1);

    }
}
