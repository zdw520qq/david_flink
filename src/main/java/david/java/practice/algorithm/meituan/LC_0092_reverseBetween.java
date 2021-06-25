package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 1 <= left <= right <= n
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * @Author: David
 * @Date: Create in 上午11:35 2021/5/30
 */
public class LC_0092_reverseBetween extends DavidBase {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        if (left == right || head == null) {
            return dummy.next;
        }

        ListNode pin = dummy;
        int count = 0;

        while (count < left - 1) {
            pin = pin.next;
            count++;
        }

        // left  指向的node
        ListNode pointer = pin.next;
        ListNode tmp;

        while (count + 2 <= right) {
            tmp = pointer.next;
            pointer.next = tmp.next;
            tmp.next = pin.next;
            pin.next = tmp;

            count++;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode node = getCustomInputSingleListNode(arr);
        System.out.println(node);
        ListNode listNode = reverseBetween(node, 2, 4);
        System.out.println(listNode);
    }
}
