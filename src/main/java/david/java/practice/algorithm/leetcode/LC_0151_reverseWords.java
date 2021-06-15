package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.Stack;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:22 2021/5/30
 */
public class LC_0151_reverseWords extends DavidBase {

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (sb.length() != 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() != 0) {
            stack.push(sb.toString());
        }

        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        String trim = trim(sb.toString());
        return trim;
    }


    private static String trim(String str) {
        int i = 0, j = str.length() - 1;
        int start = -1, end = -1;
        while (i < str.length()) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
            i++;
        }
        if (start != -1) {
            while (j >= 0) {
                if (str.charAt(j) != ' ') {
                    end = j;
                    break;
                }
                j--;
            }
        }

        return start == -1 ? "" : str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

        System.out.println(s.substring(1, 3));


    }
}
