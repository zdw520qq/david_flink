package david.java.practice.algorithm.niuke;

import java.util.*;

/**
 * @Description: 题目描述
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 * <p>
 * 输入: {1,2,3}
 * <p>
 * 输出: [[1,2,3],[2,1,3],[2,3,1]]
 * <p>
 * tips:
 * <p>
 * 先序：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
 * <p>
 * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
 * <p>
 * 后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
 * @Author: David
 * @Date: Create in 下午12:02 2021/1/12
 */
public class NC45_BinaryTreeTraserve {


    public static void main(String[] args) {
        TreeNode treeNode = generateInstance();
        // int length = getLength(treeNode);
        // System.out.println(length);
        // List<Integer> list1 = new ArrayList<>();
        // // List<Integer> list2 = new ArrayList<>();
        // preOrderTraversal(treeNode, list1);
        // //
        // int[] num2 = new int[8];
        // midOrderTraversal(treeNode, num2);
        // //
        // System.out.println(list1);
        // //
        // Arrays.stream(num2).forEach(t -> System.out.print(t + ", "));
        // System.out.println();
        // //
        // int[] num3 = new int[8];
        // postOrderTraversal(treeNode, num3);
        // Arrays.stream(num3).forEach(t -> System.out.print(t + ", "));
        // System.out.println();
        // System.out.println("===== no recursive");
        //
        // List<Integer> i1 = dfsPreOrder(treeNode);
        // System.out.println(i1);
        //
        // List<Integer> i2 = dfsMidOrder(treeNode);
        // System.out.println(i2);
        //
        // List<Integer> i3 = dfsPostOrder(treeNode);
        // System.out.println(i3);

        // System.out.println("======= deque =======");
        // Deque<Integer> deque = new ArrayDeque<>();
        // deque.push(1);
        // deque.push(2);
        // deque.push(3);
        // System.out.println(deque);
        // System.out.println(deque.pollFirst());      //3
        // System.out.println(deque.pollLast());    //1
        // System.out.println(deque.pop()); //3
        // System.out.println(deque);

        // System.out.println("========= queue =======");
        // LinkedList<Integer> link  = new LinkedList<>();
        // link.add(1);
        // link.add(2);
        // link.add(3);
        // System.out.println(link);
        // System.out.println(link.getFirst());
        // System.out.println(link.getLast());
        // System.out.println(link.pop());

        System.out.println("======== bfs level order =========");
        List<Integer> int4 = bfsOrder(treeNode);
        System.out.println(int4);

    }


    /**
     * 为了打印方便就用了 list了
     *
     * @param head
     * @return
     */
    static void preOrderTraversal(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        list.add(head.val);
        preOrderTraversal(head.left, list);
        preOrderTraversal(head.right, list);

    }

    static List<Integer> dfsPreOrder(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }

        return result;
    }

    /**
     * breadth first search  广度优先, 层序
     * @param head
     * @return
     */
    static List<Integer> bfsOrder(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (head == null) {
            return result;
        }
        deque.push(head);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pollLast();
            result.add(pop.val);
            if(pop.left != null) {
                deque.push(pop.left);
            }
            if(pop.right != null) {
                deque.push(pop.right);
            }
        }

        return result;
    }

    static List<Integer> dfsMidOrder(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            cur = pop.right;
        }

        return result;
    }

    static List<Integer> dfsPostOrder(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = head;
        //标记最后一个节点, 当最后一个节点往上的时候,如果没有last标记, 那个peek的时候永远不会为null
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == last) {
                result.add(cur.val);
                stack.pop();
                last = cur;
                cur = null;

            } else {
                cur = cur.right;
            }
        }
        return result;
    }



    static int i = 0;
    static int j = 0;

    static void midOrderTraversal(TreeNode head, int[] num) {
        if (head == null) {
            return;
        }
        midOrderTraversal(head.left, num);
        num[i++] = head.val;
        midOrderTraversal(head.right, num);

    }

    static void postOrderTraversal(TreeNode head, int[] num) {
        if (head == null) {
            return;
        }
        postOrderTraversal(head.left, num);
        postOrderTraversal(head.right, num);
        num[j++] = head.val;

    }


    /**
     * 获取treeNode的节点数
     *
     * @param head
     * @return
     */
    static int getLength(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + getLength(head.left) + getLength(head.right);
    }


    public int[] leverOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        System.out.println(stack);

        return null;
    }


    /**
     * a treeNode below
     * 先序遍历： 1 2 4 3 5 6 7 8
     * 中序遍历： 4 2 1 3 5 7 6 8
     * 后序遍历： 4 2 7 8 6 5 3 1
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
    static TreeNode generateInstance() {
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


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
