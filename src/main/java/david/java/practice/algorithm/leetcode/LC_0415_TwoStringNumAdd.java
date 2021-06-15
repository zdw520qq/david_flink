package david.java.practice.algorithm.leetcode;


/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午3:23 2021/5/21
 */
public class LC_0415_TwoStringNumAdd {


    public static String solve(String num1, String num2) {
        // write code here
        int l1 = num1.length() -1;
        int l2 = num2.length() -1;
        int add = 0;

        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >=0 || add > 0) {
            int n1 = l1 >=0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >=0 ? num2.charAt(l2) - '0' : 0;
            sb.append((n1 + n2 + add) % 10);
            add = (n1 + n2 + add) / 10;
            l1 --;
            l2 --;
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
