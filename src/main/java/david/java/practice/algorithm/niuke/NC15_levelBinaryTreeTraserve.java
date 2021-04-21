package david.java.practice.algorithm.niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: 二叉树层序遍历
 * @Author: David
 * @Date: Create in 下午2:48 2021/2/12
 */
public class NC15_levelBinaryTreeTraserve {

    public static void main(String[] args) {
        TreeNode treeNode = generateInstance();
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(treeNode);
        System.out.println(arrayLists);


    }



    /**
     * 题解:
     * 此题要用到deque, 一头进一头出
     * 但是, 结果是是每层要撞到一个list里面, 所以, 在poll的时候,必须要知道poll的是属于哪一层的, 要记住deque的size, 没次size--, 当==0的时候,开始向下一个list装
     *
     *
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            //目的是标记每一行有多少个,这样就知道是哪层的,无论里层怎么add或push, size只记录这一层的size
            int size = deque.size();
            ArrayList<Integer> result = new ArrayList<>();
            while (size > 0) {
                TreeNode last = deque.pollLast();
                result.add(last.val);
                if (last.left != null) {
                    deque.push(last.left);
                }
                if (last.right != null) {
                    deque.push(last.right);
                }
                size--;
            }
            results.add(result);
        }

        return results;
    }



    /**
     * a treeNode as below
     * 先序遍历： 1 2 4 3 5 6 7 8    根左右
     * 中序遍历： 4 2 1 3 5 7 6 8    左根右
     * 后序遍历： 4 2 7 8 6 5 3 1    左右根
     * 层序遍历:  1 2 3 4 5 6 7 8
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


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}



