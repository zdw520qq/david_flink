package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * @Author: David
 * @Date: Create in 下午3:37 2021/4/22
 */
public class LC_0021_mergeTwoLists extends DavidBase {
    // 就是归并
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode next = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val ) {
                next.next = l2;
                l2 = l2.next;
            } else {
                next.next = l1;
                l1 = l1.next;
            }
            next = next.next;
        }

        while (l1 != null) {
            next.next = l1;
            l1 = l1.next;
            next = next.next;
        }

        while (l2 != null) {
            next.next = l2;
            l2 = l2.next;
            next = next.next;
        }

        return node.next;
    }
}
