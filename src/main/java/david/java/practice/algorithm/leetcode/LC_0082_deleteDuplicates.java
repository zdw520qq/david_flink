package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * @Author: David
 * @Date: Create in 下午3:27 2021/5/30
 */
public class LC_0082_deleteDuplicates extends DavidBase {


    /**
     * 题解:  两个变量, 一个 cur, 一个next , 可以理解是 两个指针,  next 即 cur.next 不停的向下,  直到符合的时候,  cur = cur.next
     * 代表着已经加进入了
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        if (head == null) {
            return dummy.next;
        }


        ListNode cur = dummy;
        ListNode next = dummy.next;

        // dummy ->  next -> next.next
        //
        while (next != null && next.next != null) {

            if (next.val == next.next.val) {
                int val = cur.next.val;
                while (next.next != null) {
                    if (next.next.val == val) {
                        next = next.next;
                    }else {
                        break;
                    }
                }
                // 此时 next == null  ||  next 的val 不等于前一个 的val
                next = next.next;
                cur.next = next;
            } else {
                cur = cur.next;
                next = next.next;
            }

        }


        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode customInputSingleListNode = getCustomInputSingleListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println(deleteDuplicates(customInputSingleListNode));


    }

}
