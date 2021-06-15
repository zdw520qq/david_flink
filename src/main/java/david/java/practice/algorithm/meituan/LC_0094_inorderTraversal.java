package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午8:54 2021/5/30
 */
public class LC_0094_inorderTraversal extends DavidBase {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midTraverse(root, list);
        return list;
    }

    private void midTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        midTraverse(root.left, list);
        list.add(root.val);
        midTraverse(root.right, list);
    }
}
