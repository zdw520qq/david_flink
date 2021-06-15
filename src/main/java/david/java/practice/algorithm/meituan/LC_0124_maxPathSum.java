package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * @Author: David
 * @Date: Create in 下午2:26 2021/5/30
 */
public class LC_0124_maxPathSum extends DavidBase {

    int maxSum = Integer.MIN_VALUE;

    /**
     * 题解: 递归求出 每个节点的 最大增益
     * 从子节点开始
     * 比如 :
     * 1
     * / \
     * -1   2
     * 先计算 -1 和 2   , 2 的最大增益是 2, -1 的最大增益是 -1, 因为是负数, 那路线就不要走 -1了, 即最大争议设为0即可,
     * 在计算 1的最大增益 = Max (left的最大增益 + right的最大增益 + 本身 ,0 )
     * 所以路线是 1->2  即 3
     *
     *
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMaxGain = Math.max(maxGain(node.left), 0);
        int rightMaxGain = Math.max(maxGain(node.right), 0);

        //此处不需要跟0比较,因为必须要有一个节点, 所以如果 都是负的话, 那结果就是负数
        int curGain = leftMaxGain + rightMaxGain + node.val;
        maxSum = Math.max(curGain, maxSum);

        // 这里就是题意的理解了, 只加一条边, 而不是两个都加
        // 因为curGain = 左节点增益 + 右节点增益,  增益是一条路线,  而不是该节点下所有节点之和. 所以不要return curGain
        return node.val + Math.max(leftMaxGain, rightMaxGain);
    }


}
