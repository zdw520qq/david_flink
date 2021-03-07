package david.java.practice.algorithm.niuke;

import david.java.practice.algorithm.Base;

/**
 * @Description: 链表中的节点每k个一组翻转
 * <p>
 * 题目描述
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 * <p>
 * 示例1
 * 输入
 * 复制
 * {1,2,3,4,5},2
 * 返回值
 * 复制
 * {2,1,4,3,5}
 * @Author: David
 * @Date: Create in 上午10:10 2021/3/4
 */
public class NC50_reverseLinkedNodePerK extends Base {


    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }


        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pointer = dummy;
        ListNode cur = head;
        ListNode tmp = null;

        int len = 1;
        while (head.next != null) {
            len++;
            head = head.next;
        }

        if (k > len) {
            return dummy.next;
        }

        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {

                //此步骤为插头法交换,由 pointer -> 1 -> 2 -> 3 -> 4
                //              变为 pointer -> 2 -> 1 -> 3 -> 4
                // 可以明显看出插头法的cur是一直不变的, 每次cur的next是一直向下的, 原next跑到了头部
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pointer.next;
                pointer.next = tmp;

            }

            pointer = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = l2;

        System.out.println(l1.toString());

        NC50_reverseLinkedNodePerK method = new NC50_reverseLinkedNodePerK();
        ListNode listNode = method.reverseKGroup(l1, 3);


        while (listNode != null) {
            System.out.println(listNode.val + ", ");
            listNode = listNode.next;
        }


    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}
