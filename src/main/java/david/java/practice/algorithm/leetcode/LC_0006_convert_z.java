package david.java.practice.algorithm.leetcode;

import java.util.ArrayList;

/**
 * @Description: Z 字形变换
 * @Author: David
 * @Date: Create in 下午7:34 2021/3/11
 */
public class LC_0006_convert_z {



    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

    }

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
                k ++;
            } else {
                k --;
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