package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import javax.swing.tree.TreeNode;

/**
 * @Description: 二叉树直径
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * @Author: David
 * @Date: Create in 下午3:44 2021/5/31
 */
public class LC_0543_diameterOfBinaryTree extends DavidBase {

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        findLength(root);
        return max -1 ;
    }

    private static int findLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findLength(root.left);
        int right = findLength(root.right);

        max = Math.max(max, left + right + 1);

        //肯定是一条边
        return Math.max(left, right) + 1;
    }


    static int ans;
    public static int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public static int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;

        int i = diameterOfBinaryTree(t1);
        System.out.println(i);


    }
}
