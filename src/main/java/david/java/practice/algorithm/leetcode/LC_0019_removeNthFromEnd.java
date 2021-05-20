package david.java.practice.algorithm.leetcode;


import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @Author: David
 * @Date: Create in 上午11:31 2021/4/21
 */
public class LC_0019_removeNthFromEnd extends DavidBase {
    /**
     * 题解: 方法一: 先遍历测出长度, 在算出的node更改指针
     * 方法二: 不需要测出长度, 使用双指针, 前后两个指针相差 n,这样 fist到底的时候, second后面的就是要删除的
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int length = getLength(head);

        if (n == length) {
            return head.next;
        }

        int delIndex = length - n;
        ListNode pre = head;
        for (int i = 0; i < delIndex - 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return head;
    }

    private static int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    /**
     * 双指法法
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        if (head == null || head.next == null) {
            return null;
        }

        ListNode f = dummy;
        ListNode s = dummy;

        int count = -n;

        while(f.next != null) {
            f = f.next;
            if(count >= 0) {
                s = s.next;
            }
            count++;
        }
        if(s == dummy) {
            dummy.next = dummy.next.next;
        } else {
            s.next = s.next.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node = getInputSingleListNode(new int[]{1,2});
        // ListNode node = getInputSingleListNode(new int[]{1,2,3,4,5});
        System.out.println(node);

        ListNode node1 = removeNthFromEnd2(node, 1);
        System.out.println(node1);
    }
}
