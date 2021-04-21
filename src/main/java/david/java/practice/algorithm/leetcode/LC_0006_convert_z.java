package david.java.practice.algorithm.leetcode;

import java.util.ArrayList;

/**
 * @Description: Z 字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * @Author: David
 * @Date: Create in 下午7:34 2021/3/11
 */
public class LC_0006_convert_z {


    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

    }

    /**
     * 题解:
     * numRows为几,则要创建几个List<stringBuilder>
     *
     * 建个标志位, down = true,代表index向下走, down=false 代表index向上走, index是list的下标
     *
     *
     * @param s
     * @param numRows
     * @return:
     */
    public String convert(String s, int numRows) {

        if (s == null || s.length() == 1 || numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean down = true;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(k).append(s.charAt(i));
            if (down) {
                k++;
            } else {
                k--;
            }
            if (k >= numRows) {
                down = false;
                k -= 2;
            }
            if (k < 0) {
                down = true;
                k += 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder builder : list) {
            sb.append(builder);
        }

        return sb.toString();

    }
}