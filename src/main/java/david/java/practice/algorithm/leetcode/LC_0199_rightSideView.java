package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树的右视图
 * <p>
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: David
 * @Date: Create in 下午5:23 2021/6/21
 */
public class LC_0199_rightSideView extends DavidBase {

    /**
     * 题解:层序遍历, add 每层的最后一个
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                TreeNode node = list.pollFirst();
                if (size == 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                size--;
            }

        }

        return result;
    }
}
