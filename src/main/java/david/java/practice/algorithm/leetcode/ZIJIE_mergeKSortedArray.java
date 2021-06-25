package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Description: 合并k个有序数组
 * <p>
 * [1,2,3],  [5,7,8,9], [3,4,7]...
 * @Author: David
 * @Date: Create in 上午11:16 2021/6/23
 */
public class ZIJIE_mergeKSortedArray extends DavidBase {


    /**题解:
     * 本题的难度是在于k 值不确定, 且为数组 或者list,  如果是 链表的话, 简单for循环即可, 每次poll出, 但是array 和list
     * 需要记录index值, 而这个变量是动态的.
     *
     * 方法一: 分治思想, 使用归并排序, 将这个二维数组  递归拆分成  k 个 1维数组, 然后 两两合并.
     * 方法二: 用插入法 + 二分法, 记录上次插入的index ,然后 向后做二分法.
     * 方法三: 创建个 size 为 k 的 小根堆, 先将每组的第一个插入到小根堆内, 进行一次排序; 然后取出堆顶元素所在的array的后一个元素, 在调整堆,
     * 如果 array 到最后了,则直接给 Integer.maxValue
     *
     * */


    /**
     * 方法三
     */
    public int[] fun3(int[][] arr) {

        // keuy
        Map<Integer, Integer> map = new HashMap<>();

        return null;

    }


    public static void main(String[] args) {
    }
}
