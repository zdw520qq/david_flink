package david.java.practice.algorithm;


import david.java.practice.algorithm.niuke.NC45_BinaryTreeTraserve;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午8:30 2021/2/20
 */
public abstract class DavidBase {

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

    public static List<Integer> arr2List(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
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


   public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * a treeNode as below
     * 先序遍历： 1 2 4 3 5 6 7 8    根左右
     * 中序遍历： 4 2 1 3 5 7 6 8    左根右
     * 后序遍历： 4 2 7 8 6 5 3 1    左右根
     * <p>
     *                  1
     *                /  \
     *               2    3
     *              /      \
     *             4        5
     *                       \
     *                       6
     *                       / \
     *                       7   8
     *
     * @return
     */
    public static TreeNode getBinaryTreeInstance() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node5.right = node6;
        node6.left = node7;
        node6.right = node8;

        return node1;
    }

    public static void main(String[] args) {
        ListNode customInputSingleListNode = getInputSingleListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(customInputSingleListNode.toString());
    }
}
