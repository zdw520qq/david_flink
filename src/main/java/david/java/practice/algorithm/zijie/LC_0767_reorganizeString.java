package david.java.practice.algorithm.zijie;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 重构字符串
 * <p>
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * @Author: David
 * @Date: Create in 下午3:54 2021/6/25
 */
public class LC_0767_reorganizeString extends DavidBase {


    /**
     * 题解: 首先统计每个char 的个数, 如果 其中一个 的个数  > (n + 1)/2,   n + 1 是为了 考虑 n  为奇数和偶数 那明显不行.
     *
     * 方法一:
     * 将所有的 char: count  排序,  先将最多的, 向结果数组里面放,  1,3,5,7,9...放,  后面的一样, 放满之后, 放2,4,6,8...
     *
     * 方法二:
     * 建个 char类别个数的 大根堆, 每次去 第一和第二的 放入结果array中, 然后 heap sort ,然后在重复
     *
     *
     */
    public String reorganizeString(String s) {

        // TODO: 2021/6/25
        return null;
    }
}
