package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意:合并必须从两个树的根节点开始。
 * @Author: David
 * @Date: Create in 上午11:32 2021/4/29
 */
public class LC_0617_binarytree extends DavidBase {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode treeNode = new TreeNode(root1.val + root2.val);

        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
    }

    private static TreeNode getTestData1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        n1.left = n3;
        n1.right = n2;
        n3.left = n5;
        return n1;
    }

    private static TreeNode getTestData2() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        n2.left = n1;
        n2.right = n3;
        n1.right = n4;
        n3.right = n7;

        return n2;
    }

    public static void main(String[] args) {

        TreeNode testData1 = getTestData1();
        TreeNode testData2 = getTestData2();

        TreeNode treeNode = mergeTrees(testData1, testData2);
        System.out.println();

    }
}
