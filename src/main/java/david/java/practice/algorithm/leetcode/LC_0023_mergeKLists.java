package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.Base;

/**
 * @Description: 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * @Author: David
 * @Date: Create in 下午2:51 2021/4/25
 */
public class LC_0023_mergeKLists extends Base {

    /**
     * 题解:使用归并排序
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        ListNode node = findMinNode(lists);
        while (node != null) {
            pointer.next = node;
            pointer = pointer.next;
            node = findMinNode(lists);
        }

        return dummy.next;
    }

    private static ListNode findMinNode(ListNode[] lists) {
        Integer index = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (lists[i].val < min) {
                min = lists[i].val;
                index = i;
            }
        }

        if(index == null) {
            return null;
        }

        ListNode node = lists[index];
        lists[index] = lists[index].next;

        return node;
    }

}
