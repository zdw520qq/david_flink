package david.java.practice.algorithm.meituan;

import java.util.Stack;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:23 2021/5/21
 */
public class TwoStringNumAdd {


    public static String solve(String s, String t) {
        // write code here
        int sLength = s.length();
        int tLength = t.length();

        int i = sLength - 1, j = tLength - 1;

        int tip = 0;
        StringBuilder sb = new StringBuilder();

        // Stack<Integer> stack = new Stack<>();


        while (i >= 0 && j >= 0) {

            int is = Integer.parseInt(String.valueOf(s.charAt(i)));
            int it = Integer.parseInt(String.valueOf(t.charAt(j)));

            int num = (is + it + tip) % 10;
            tip = (is + it + tip) / 10;

            sb.append(num);

            i--;
            j--;

        }

        // s 比较长
        while (i >= 0) {
            int is = Integer.parseInt(String.valueOf(s.charAt(i--)));
            int num = (is + tip) % 10;
            tip = (is + tip) / 10;
            sb.append(num);
        }

        // t 比较长
        while (j >= 0) {
            int it = Integer.parseInt(String.valueOf(s.charAt(j--)));
            int num = (it + tip) % 10;
            tip = (it + tip) / 10;
            sb.append(num);
        }

        if (tip == 1) {
            sb.append(tip);
        }

        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        String s1 = "2989";
        String s2 = "41";
        String solve = solve(s1, s2);
        System.out.println(solve);



    }
}
