package david.java.algorithm.niuke;

import java.util.List;

/**
 * @Description:
 *
 * 题目描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度的解法么？
 *
 * 解决思路:
 * 快慢指针的解法， 一个指针走两步 一个指针走一步，如果快指针直接到了null 说明没有环， 如果有环的话 总有一次结果会让快指针和慢指针相等。
 *
 * @Author: David
 * @Date: Create in 下午7:41 2021/1/11
 */
public class NC4_IdentifyLinkCycle {

    public static boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        // double step
        ListNode d = head;
        // single step
        ListNode s = head;

        while (d != null && d.next != null) {
            d = d.next.next;
            s = s.next;
            if (d == s) {
                return true;
            }
        }

        return false;
    }





    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
