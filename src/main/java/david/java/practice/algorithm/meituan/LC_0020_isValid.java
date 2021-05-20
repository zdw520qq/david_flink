package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
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
 * @Author: David
 * @Date: Create in 上午10:12 2021/5/17
 */
public class LC_0020_isValid extends DavidBase {

    private static Map<Character, Character> map = new HashMap<Character, Character>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }


    public static boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }

        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                Character peek = list.peek();
                if (map.get(chars[i]).equals(peek)) {
                    list.pop();
                } else {
                    return false;
                }
            } else {
                list.push(chars[i]);
            }
        }

        return list.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.peek());
        // list.push(1);
        // list.push(2);
        // list.push(3);
        // System.out.println(list.get(0));
        // System.out.println(list.poll());
        // Stack<Integer> stack = new Stack<Integer>();
        // System.out.println(stack.peek());
    }

}
