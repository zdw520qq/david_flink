package david.java.practice.algorithm.leetcode;

/**
 * @Description: 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 * @Author: David
 * @Date: Create in 下午8:46 2021/4/25
 */
public class LC_0028_strStr {

    /**
     * 暴利破解
     */
    public static int strStr(String haystack, String needle) {
        if(haystack.equals("") && needle.equals("")){
            return 0;
        }
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();
        for (int i = 0; i <= s1.length-s2.length; i++) {
            boolean b = true;
            for (int j = 0; j < s2.length; j++) {
                if (s1[i+j] != s2[j]) {
                    b = false;
                    break;
                }
            }
            if(b){
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        // System.out.println(strStr("hello", "ll"));
        // System.out.println(strStr("", ""));
        System.out.println(strStr("a", "a"));
    }
}
