package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 压缩字符串
 * <p>
 * 给定一组字符，使用原地算法将其压缩。
 * <p>
 * 压缩后的长度必须始终小于或等于原数组长度。
 * <p>
 * 数组的每个元素应该是长度为1的字符（不是 int 整数类型）。
 * <p>
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * <p>
 * 输出：
 * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * <p>
 * 说明：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * <p>
 * 输入：
 * ["a"]
 * <p>
 * 输出：
 * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * <p>
 * 解释：
 * 没有任何字符串被替代。
 * 示例 3：
 * <p>
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * 输出：
 * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 * <p>
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 * <p>
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * @Author: David
 * @Date: Create in 上午10:29 2021/6/11
 */
public class LC_443_compress extends DavidBase {


    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int index = 0;
        int left = 0;
        int right = 1;

        while (right <= chars.length) {
            if (chars[left] == chars[right]) {
                right++;
            } else {
                chars[index++] = chars[left];
                String redundent = String.valueOf(right - left);
                if (!redundent.equals("1")) {
                    for (int i = 0; i < redundent.length(); i++) {
                        chars[index++] = redundent.charAt(i);
                    }
                }

                left = right;
            }
        }
        chars[index++] = chars[left];
        String redundent = String.valueOf(right - left);
        if (!redundent.equals("1")) {
            for (int i = 0; i < redundent.length(); i++) {
                chars[index++] = redundent.charAt(i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        // char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        LC_443_compress lc = new LC_443_compress();
        int compress = lc.compress(chars);
        System.out.println(compress);
    }
}
