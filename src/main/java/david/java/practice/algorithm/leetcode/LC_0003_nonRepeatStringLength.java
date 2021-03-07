package david.java.practice.algorithm.leetcode;

import java.util.HashSet;

/**
 * @Description: 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 
 * @Author: David
 * @Date: Create in 下午7:23 2021/3/6
 */
public class LC_0003_nonRepeatStringLength {

    /**
     * 双指针法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int max = 1;
        int left = 0;
        // 如果优化一下, 没必要设变量right, 因为right 就是 i
        int right = 1;

        for (int i = 1; i < length; i++) {

            // 如果set包含了,就是有重复的了,那么左指针向右移动,并把左指针对应的char抛掉, 直到无重复为止
            while (right <= length && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // 如果没有重复的,那么右指针一直向右;
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
            right ++;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);


    }

}
