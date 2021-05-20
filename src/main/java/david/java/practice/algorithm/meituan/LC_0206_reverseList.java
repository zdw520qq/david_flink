package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午8:45 2021/5/17
 */
public class LC_0206_reverseList extends DavidBase {
    public static  ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        // ListNode next = head.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {

        ListNode inputSingleListNode = getInputSingleListNode();
        ListNode node = reverseList(inputSingleListNode);
        System.out.println(node);

    }
}
