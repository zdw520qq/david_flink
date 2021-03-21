package david.java.practice.algorithm.leetcode;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午10:02 2021/3/8
 */
public class LC_0005_longestPalindrome {

    /**
     * 第一种, 动态规划, 主要思路是, 如果一个字符串是 回文字符串, 那么去掉首位, 他仍然是回文, 如果不是,就pass掉
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        int n = s.length();
        char[] chars = s.toCharArray();

        int maxLength = 1;
        int begin = 0;

        boolean[][] matrix = new boolean[n][n];
        //矩阵的对称轴肯定是true
        for (int i = 0; i < n; i++) {
            matrix[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]){
                    if (i - j < 3) {
                        matrix[j][i] = true;
                    } else {
                        matrix[j][i] = matrix[j + 1][i - 1];
                    }
                }

                if (matrix[j][i] && i - j + 1 > maxLength) {
                    maxLength = i - j + 1;
                    begin = j;
                }
            }
        }

        return s.substring(begin , begin + maxLength);
    }


    public static void main(String[] args) {
        String s = "babad";
        String s2 = "aacabdkacaa";
        String s1 = longestPalindrome(s2);
        System.out.println(s1);
    }
}