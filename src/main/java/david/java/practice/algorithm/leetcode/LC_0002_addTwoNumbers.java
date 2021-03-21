package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.Base;

/**
 * @Description: 两数相加
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * @Author: David
 * @Date: Create in 下午6:38 2021/3/6
 */
public class LC_0002_addTwoNumbers extends Base {
    /**
     * 题解:
     * 先将两个链表翻转,这样位数就对齐了,都是从个位开始
     *
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tmp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            ListNode listNode = new ListNode(sum % 10);

            if (head == null) {
                head = listNode;
                tmp = head;
            } else {
                tmp.next = listNode;
                tmp = tmp.next;
            }

            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = getInputSingleListNode(new int[]{9, 9, 9});
        ListNode a2 = getInputSingleListNode(new int[]{9, 9, 9, 9, 9});
        ListNode listNode = addTwoNumbers(a1, a2);
        System.out.println(listNode.toString());
    }
}
