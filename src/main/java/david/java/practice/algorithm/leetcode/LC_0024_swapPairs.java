package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.Base;

/**
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * @Author: David
 * @Date: Create in 下午5:43 2021/4/22
 */
public class LC_0024_swapPairs extends Base {


    /**
     * 题解: 类似于牛客第50题, 每隔几个翻转一次列表
     * 先设这个基准点,然后基准点后的第一个和第二个交换位置, 之后基准点移到新的第二个节点, 使用的是插头法.
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pivot = dummy;
        ListNode third = null;
        ListNode first = null;
        ListNode second = null;

        while (pivot.next != null && pivot.next.next != null) {
            first = pivot.next;
            second = first.next;
            third = second.next;

            pivot.next = second;
            second.next = first;
            first.next = third;
            pivot = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode inputSingleListNode = getInputSingleListNode(new int[]{1, 2, 3, 4});
        ListNode node = swapPairs(inputSingleListNode);
        System.out.println(node);
    }
}
