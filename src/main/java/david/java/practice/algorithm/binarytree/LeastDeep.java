package david.java.practice.algorithm.binarytree;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 求二叉树最短的深度
 * @Author: David
 * @Date: Create in 下午3:44 2021/4/28
 */
public class LeastDeep extends DavidBase {


    /**
     * 功能描述: 递归查找二叉树的最浅深度, 我把所有的叶子节点的深度查出来了 ,然后在排序
     */
    private static void findLeastDeep(TreeNode treeNode, int deep, List<Integer> list) {
        if (treeNode.left != null) {
            findLeastDeep(treeNode.left, deep + 1, list);
        }
        if (treeNode.right != null) {
            findLeastDeep(treeNode.right, deep + 1, list);
        }
        if (treeNode.left == null && treeNode.right == null) {
            list.add(deep);
        }
    }



    public static int leastDeep(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        findLeastDeep(treeNode, 1, list);
        Collections.sort(list);
        return list.get(0);
    }


    /**
     * 功能描述: tree 最大深度
     * @return:
     */
    private static int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int r = maxDeep(root.right);
        int l = maxDeep(root.left);
        return Math.max(r, l) + 1;
    }



    public static void main(String[] args) {
        TreeNode binaryTreeInstance = getBinaryTreeInstance();
        // TreeNode binaryTreeInstance = getInstance();
        // int i = leastDeep(binaryTreeInstance);
        // System.out.println(i);
        // int deep = maxDeep(binaryTreeInstance);
        // System.out.println(deep);
        // int minDeep = minDeep(binaryTreeInstance);
        // System.out.println(minDeep);

        // List<Integer> list = new ArrayList<>();
        // System.out.println(list);

    }

    private static TreeNode getInstance() {
        TreeNode tree = new TreeNode(0);
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);


        tree.left = tree1;
        tree1.left = tree2;
        tree2.left = tree3;
        tree.right = tree4;
        tree3.left = tree5 ;

        return tree;
    }

}
