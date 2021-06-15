package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import javax.swing.tree.TreeNode;

/**
 * @Description: 翻转一棵二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author: David
 * @Date: Create in 上午10:16 2021/6/11
 */
public class LC_0226_invertTree extends DavidBase {


    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    private void recursive(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        recursive(root.left);
        recursive(root.right);
    }
}
