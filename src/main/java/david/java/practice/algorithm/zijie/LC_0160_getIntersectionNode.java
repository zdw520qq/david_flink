package david.java.practice.algorithm.zijie;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 编写一个程序，找到两个单链表相交的起始节点。
 * @Author: David
 * @Date: Create in 下午5:45 2021/5/24
 */
public class LC_0160_getIntersectionNode extends DavidBase {

    /**
     * 题解:
     * 方法一: 遍历一个,然后放入到set中, 然后遍历领一个,并在set内查找,  空间复杂度为 n
     * 方法二:
     *
     * 1 -> 2 -> 3 -> 4
     *                   \
     *           5 -> 6 - 7  -> 8
     * 不相同的部分是 1 ~ 4, 5 ~6 ,相同的是 7,8
     * 所以
     * 1 2 3 4 7 8 -> 5 6 => 7
     * 5 6 7 8 -> 1 2 3 4 => 7
     * 链表a表里完后,在遍历b,  链表b遍历完后,遍历a, 那么他们肯定会在 第二遍的7 相遇, 因为走过的举例一样
     *
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        // a + b 与 b + a 长度相同, 到最后如果两个没有相交的话,两个都是null, 即null == null
        while (a != b) {
            if (a != null) {
                a = a.next;
            }else {
                a = headB;
            }
            if (b != null) {
                b = b.next;
            }else {
                b = headA;
            }
        }

        return a;

    }

    public static void main(String[] args) {
        System.out.println(null == null);
        ListNode inputSingleListNode = getInputSingleListNode();
        ListNode inputSingleListNode1 = getInputSingleListNode();
        ListNode intersectionNode = getIntersectionNode(inputSingleListNode, inputSingleListNode1);
        System.out.println(intersectionNode);
    }
}
