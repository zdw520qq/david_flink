package david.java.practice.algorithm.leetcode;

/**
 * @Description: 正则表达式
 * <p>
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * @Author: David
 * @Date: Create in 下午5:31 2021/3/14
 */
public class LC_0010_regex {
    public static boolean isMatch(String s, String p) {
        boolean result = false;
        int i = s.length();
        int j = p.length();

        // 多出的一个用来初始化
        boolean[][] dp = new boolean[i + 1][j + 1];
        dp[0][0] = true;
        // 初始化第一列
        for (int k = 1; k <= i; k++) {
            dp[k][0] = false;
        }
        //初始化第一行
        for (int k = 1; k <= j; k++) {
            if (p.charAt(k-1) == '*') {
                dp[0][k] = dp[0][k-2];
            } else {
                dp[0][k] = false;
            }
        }


        for (int k = 1; k < i +1; k++) {
            for (int l = 1; l < j + 1; l++) {
                if (s.charAt(k - 1) == p.charAt(l -1) || p.charAt(l -1) == '.') {
                    dp[k][l] = dp[k-1][l-1];
                }
                if (p.charAt(l - 1) == '*') {
                    if (dp[k][l - 2]) {
                        dp[k][l] = true;
                    } else if (dp[k][l - 1]) {
                        dp[k][l] = true;
                    } else if ((s.charAt(k -1 ) == p.charAt(l-2) || p.charAt(l-2) == '.') && dp[k-1][l]) {
                        dp[k][l] = true;
                    } else {
                        dp[k][l] = false;
                    }
                }
            }
            
        }
        
        return dp[i][j];
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";

        boolean match = isMatch(s, p);
        System.out.println(match);


    }
}
