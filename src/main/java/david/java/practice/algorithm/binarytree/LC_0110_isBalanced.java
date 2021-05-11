package david.java.practice.algorithm.binarytree;

import david.java.practice.algorithm.Base;

/**
 * @Description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 平衡二叉树的条件:
 * 1. 左右两节点的高度差不大于1 (一个节点如果没有子节点, 那么它也是平衡二叉树)
 * 2. 左右两节点都是平衡二叉树
 * @Author: David
 * @Date: Create in 上午11:45 2021/4/30
 */
public class LC_0110_isBalanced extends Base {

    /**
     * 题解:
     * 1. 第一步: 要先求出左右节点的深度, lDeep 与 rDeep,
     * 2. 一个节点的是否为平衡二叉树的条件是: Math.abs(lDeep - rDeep) <=1 && isBalanced(root.left) && isBalenced(root.right)
     */
    public boolean isBalanced(TreeNode root) {
        return true;
    }

    /**
     * 节点的深度
     */
    private int deep(TreeNode root) {
        if (root == null) {
            return 1;
        }
        if (deep(root.right) <= deep(root.left)){
            return 1 + deep(root.left);
        } else {
            return 1 + deep(root.right);
        }
    }
}
