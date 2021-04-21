package david.java.practice.algorithm.leetcode;

/**
 * @Description:
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * @Author: David
 * @Date: Create in 下午10:02 2021/3/8
 */
public class LC_0005_longestPalindrome {

    /**
     * 第一种, 动态规划, 主要思路是, 如果一个字符串是 回文字符串, 那么去掉首位, 他仍然是回文, 如果不是,就pass掉
     * 在纸上画矩阵,进行辅助
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