package david.java.practice.algorithm.binarytree;

/**
 * @Description: 查找二叉树的两个节点的最短路径
 *
 * 题解:
 *
 *
 * 1. 先求两个节点最小的公共祖先 LCA  lowest common ancesdor
 *  参考 {@link david.java.practice.algorithm.leetcode.LC_0236_lowestCommonAncestor}
 *
 *
 *
 *
 *
 *
 * 二分查找树 BST , 比如 两个子节点 p, q, 且  p < q  都在 root节点的左边,那么 root.val  肯定>p 和 q, 那么 尝试 root.left, 反之用root.right
 * 直到  p < root < q
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 *
 * @Author: David
 * @Date: Create in 下午4:26 2021/4/28
 */
public class T001_FindTowTreeNodeLeastPath {

}
