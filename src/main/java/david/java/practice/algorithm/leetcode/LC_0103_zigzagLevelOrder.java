package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description: 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: David
 * @Date: Create in 下午4:19 2021/5/24
 */
public class LC_0103_zigzagLevelOrder extends DavidBase {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean asc = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int k = size;
            List<Integer> list = new ArrayList<>();
            while (k > 0) {
                if (asc) {
                    TreeNode first = deque.pollFirst();
                    list.add(first.val);
                    if (first.left != null) {
                        deque.add(first.left);
                    }
                    if (first.right != null) {
                        deque.add(first.right);
                    }
                }else {
                    TreeNode first = deque.pollLast();
                    list.add(first.val);
                    if (first.right != null) {
                        deque.push(first.right);
                    }
                    if (first.left != null) {
                        deque.push(first.left);
                    }

                }

                k--;
            }
            result.add(list);
            asc = !asc;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode binaryTreeInstance = getBinaryTreeInstance();
        List<List<Integer>> lists = zigzagLevelOrder(binaryTreeInstance);
        System.out.println(lists);
    }
}
