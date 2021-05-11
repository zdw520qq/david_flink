package david.java.practice.algorithm.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @Description:
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 * @Author: David
 * @Date: Create in 上午10:09 2021/4/28
 */
public class LC_0032_longestValidParentheses {

    /**
     * 用栈最简单:  stack 里面存的是 ( 所在的下标,
     * 每次匹配到 ) 的时候就 pop一下stack, 然后用 当前的 下标减去  stack.peek 一下, 就是本次的最长.
     */
    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        if (s == null || s.length() == 0) {
            return maxLength;
        }
        //stack 里面存的是索引,里面放一个 -1 是为了处理边界问题,不放也没事,但是自己要处理下
        Stack<Integer> q = new Stack<>();
        q.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                q.push(i);
            }else {
                Integer pop = q.pop();
                if (q.isEmpty()) {
                    q.push(i);
                }
                maxLength = Math.max(maxLength, i - q.peek());
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = ")()())";
        int i = longestValidParentheses(s);
        System.out.println(i);


    }
}
