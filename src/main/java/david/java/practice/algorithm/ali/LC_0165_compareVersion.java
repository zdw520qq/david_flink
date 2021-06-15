package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;
import javafx.util.Pair;

/**
 * @Description: 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * <p>
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * <p>
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * <p>
 * 如果version1>version2返回1，
 * 如果version1<version2 返回 -1，
 * 除此之外返回 0。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 示例 2：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 示例 3：
 * <p>
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 * @Author: David
 * @Date: Create in 下午10:59 2021/5/31
 */
public class LC_0165_compareVersion extends DavidBase {

    public int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();

        int p1 = 0, p2 = 0;

        int ans = 0;
        while (p1 < n1 || p2 < n2) {
            int[] v1 = getMiniVersion(version1, p1);
            int[] v2 = getMiniVersion(version2, p2);

            p1 = v1[1];
            p2 = v2[1];

            if (v1[0] > v2[0]) {
                ans = 1;
                break;
            }
            if (v1[0] < v2[0]) {
                ans = -1;
                break;
            }
        }

        return ans;
    }

    private int[] getMiniVersion(String version, int position) {
        int[] ints = new int[2];
        int length = version.length();
        if (position >= length) {
            ints[0] = 0;
            ints[1] = position;
            return ints;
        }
        int end = 0;
        for (int i = position; i < length; i++) {
            end = i;
            if (version.charAt(i) == '.') {
                break;
            }
        }
        if (end == length - 1) {
            if (version.charAt(end) != '.') {
                end++;
            }
        }

        ints[0] = Integer.parseInt(version.substring(position, end));
        ints[1] = end + 1;
        return ints;
    }

    public static void main(String[] args) {
        String s1 = "1.01";
        String s2 = "1.001";

        LC_0165_compareVersion demo = new LC_0165_compareVersion();
        int i = demo.compareVersion(s1, s2);
        System.out.println(i);
    }

}
