package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description: 字符串相乘
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * @Author: David
 * @Date: Create in 下午4:06 2021/6/15
 */
public class LC_0043_multiply extends DavidBase {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int c1 = num1.charAt(i) - '0';
            int size = sb.length();
            int add = 0;
            int j = num2.length() - 1;
            int index = num1.length() - 1 - i;

            while (j >= 0 || add > 0) {
                int c2 = j < 0 ? 0 : num2.charAt(j) - '0';
                if (num2.length() - 1 - j >= size || index >= size) {
                    sb.append((char) ((add + c1 * c2) % 10 + '0'));
                    add = (add + c1 * c2) / 10;
                } else {
                    // int preChar = sb.charAt(index) - '0';
                    int sum = add + c1 * c2 + sb.charAt(index) - '0';
                    sb.setCharAt(index, (char) ((sum % 10 + '0')));
                    add = (sum) / 10;
                }
                index++;
                j--;
            }
        }


        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LC_0043_multiply ll = new LC_0043_multiply();
        String multiply = ll.multiply("56", "34");
        System.out.println(multiply);

    }
}
