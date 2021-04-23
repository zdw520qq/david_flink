package david.java.practice.algorithm.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * @Author: David
 * @Date: Create in 下午2:54 2021/4/22
 */
public class LC_0020_isAlive {


    /**
     * 题解: 根据题意发现只有括号,没有别的字符串
     * <p>
     * 放到栈里 使用栈
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        //单数肯定不匹配
        if (chars.length % 2 == 1 || chars.length == 0) {
            return false;
        }
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for (char c : chars) {
            if (map.containsKey(c)) {
                Character pop = deque.peek();
                if (pop == null || !deque.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
        new LinkedList<>();

    }
}
