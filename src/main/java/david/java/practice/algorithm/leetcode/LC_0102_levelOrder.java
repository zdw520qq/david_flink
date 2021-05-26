package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午5:19 2021/5/17
 */
public class LC_0102_levelOrder extends DavidBase {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int size;

        while (!list.isEmpty()) {
            size = list.size();
            List<Integer> ints = new ArrayList<>();

            while (size > 0) {
                TreeNode pop = list.pop();
                ints.add(pop.val);
                if (pop.left != null) {
                    list.add(pop.left);
                }
                if (pop.right != null) {
                    list.add(pop.right);
                }
                size--;
            }
            result.add(ints);

        }

        return result;
    }


}
