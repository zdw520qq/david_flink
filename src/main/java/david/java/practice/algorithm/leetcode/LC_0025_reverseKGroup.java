package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.Base;

/**
 * @Description: 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * @Author: David
 * @Date: Create in 上午10:53 2021/4/25
 */
public class LC_0025_reverseKGroup extends Base {


    /**
     * 题解: 使用插头法, 定义一个头, 每k个,就移动下头, 然后,后面的k个一次挂载他的下面, 当这组的翻转完了,把上一组的末尾当做下一组的挂载头
     * 先求出总长度, leng/k 求出一共翻转机组.
     * 当后面不够
     * 插头法交换,由 pointer -> 1 -> 2 -> 3 -> 4
     * 变为 pointer -> 2 -> 1 -> 3 -> 4
     * 可以明显看出插头法的cur是一直不变的, 每次cur的next是一直向下的, 原next跑到了头部
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        if (k == 1) {
            return head;
        }

        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode pointer = dummy;
        ListNode first = dummy.next;
        ListNode cur = null;
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                cur = first.next;
                first.next = cur.next;
                cur.next = pointer.next;
                pointer.next = cur;
            }
            pointer = first;
            first = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode inputSingleListNode = getInputSingleListNode();
        ListNode node = reverseKGroup(inputSingleListNode, 3);
        System.out.println(node);
    }
}
