package david.java.practice.algorithm.leetcode;

/**
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * @Author: David
 * @Date: Create in 上午11:31 2021/3/23
 */
public class LC_0014_longestCommonPrefix {
    /**
     * 题解:
     * 找出strs 里面字符串最短的长度 minLength
     * 然后遍历 [0, minLength)
     *  在for循环, chatAt[i]都一样的话,加进sb里
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }
        if (minLength == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
