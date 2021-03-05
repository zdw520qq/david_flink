package david.java.practice.algorithm;


/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午8:30 2021/2/20
 */
public abstract class Base {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] getInputArray() {
        return new int[]{6, 5, 2, 7, 3, 1, 9, 8, 4, 9};
    }

    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        @Override
        public String toString() {
            ListNode tmp = this;
            StringBuilder sb = new StringBuilder();
            while (tmp != null) {
                sb.append(tmp.val).append(", ");
                tmp = tmp.next;
            }
            return sb.toString();
        }
    }

    public static ListNode getInputSingleLinkedNode() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        return l1;

    }
}
