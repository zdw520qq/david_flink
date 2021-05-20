package david.java.practice.algorithm.meituan;

import java.util.*;

/**
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * @Author: David
 * @Date: Create in 下午3:21 2021/5/20
 */
public class LC_0046_permute {

    private static List<List<Integer>> result = new ArrayList<>();

    /**
     * 题解: 使用回溯
     * 一听高大上, 其实没啥玩意, 利用递归深度遍历, 参数有的时候是 list,array ,但是这个是对象, 你在递归的这一层如果修改了, 那么会影响到
     * 其他的层, 所以你再改完之后, 把list对象传给下一层后, 然后在把你对list, array 或者其他对象在 恢复, 就行了
     */
    public static List<List<Integer>> permute(int[] nums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        recursive(nums, deque, used, nums.length, 0);
        return result;
    }

    /**
     * 第二个数用Deque 的原因是, 回溯的时候 pop就行了, 不用stack 是为了保证顺序
     */
    private static void recursive(int[] nums, Deque<Integer> deque, boolean[] used, int length, int depth) {
        if (length == depth) {
            result.add(new ArrayList<>(deque));
        }

        for (int i = 0; i < used.length; i++) {
            if(!used[i]) {
                deque.add(nums[i]);
                used[i] = true;
                recursive(nums, deque, used, length, depth + 1);
                deque.pollLast();
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] ints = {0,1};
        permute(ints);
        System.out.println(result);

    }


}
