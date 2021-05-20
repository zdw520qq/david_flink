package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.*;

/**
 * @Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @Author: David
 * @Date: Create in 下午4:49 2021/4/28
 */
public class LC_0236_lowestCommonAncestor extends DavidBase {

    private static Map<Integer, TreeNode> parent = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    //方法二用的
    private static List<Integer> path = new ArrayList<>();
    /**
     * 题解: 思路: 创建一个map<node.value, parentNode>, 遍历tree, 将每个node和其对应的parent 存入map
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findParent(root);
        while (p != null) {
            //别忘了把自己也存上
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private static void findParent(TreeNode root) {
        if (root != null && root.left != null) {
            parent.put(root.left.val, root);
            findParent(root.left);
        }
        if (root != null && root.right != null) {
            parent.put(root.right.val, root);
            findParent(root.right);
        }
    }



    public static void main(String[] args) {


        TreeNode tree = new TreeNode(2);
        TreeNode tree1 = new TreeNode(1);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);


        tree.right = tree1;

        TreeNode treeNode = lowestCommonAncestor(tree, p, q);

        System.out.println(treeNode.val);


    }

}
