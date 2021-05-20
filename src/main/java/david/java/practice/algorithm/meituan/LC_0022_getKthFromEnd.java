package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * @Author: David
 * @Date: Create in 下午8:35 2021/5/17
 */
public class LC_0022_getKthFromEnd extends DavidBase {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode f = head;
        ListNode s = head;
        int count = k;

        while (f != null) {
            if (count > 0) {
                count--;
            } else {
                s = s.next;
            }

            f = f.next;

        }
        return s;
    }
}
