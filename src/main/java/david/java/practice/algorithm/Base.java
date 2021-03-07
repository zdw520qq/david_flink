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

    public static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.toString());
    }


    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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

    public static ListNode getInputSingleListNode() {
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

    public static ListNode getInputSingleListNode(int[] arr) {
        ListNode head = null;
        ListNode tmp = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new ListNode(arr[0]);
                tmp = head;
            } else {
                tmp.next = new ListNode(arr[i]);
                tmp = tmp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode customInputSingleListNode = getInputSingleListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(customInputSingleListNode.toString());
    }
}
