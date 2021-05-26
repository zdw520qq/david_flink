package david.java.practice.algorithm.zijie;

import david.java.practice.algorithm.DavidBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 二叉树的最近公共祖先
 * @Author: David
 * @Date: Create in 下午8:33 2021/5/24
 */
public class LC_0236_lowestCommonAncestor extends DavidBase {
    static Map<TreeNode, TreeNode> map = new HashMap<>();
    static Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        resursiveFindparent(root);

        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (!set.contains(q)) {
            q = map.get(q);
        }

        return q;
    }

    /**
     * 先找到所有节点的parent
     */
    private static void resursiveFindparent(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
            resursiveFindparent(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            resursiveFindparent(root.right);
        }
    }


}
