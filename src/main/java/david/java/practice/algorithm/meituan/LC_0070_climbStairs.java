package david.java.practice.algorithm.meituan;

/**
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * @Author: David
 * @Date: Create in 下午5:26 2021/5/28
 */
public class LC_0070_climbStairs {


    /**
     * 功能描述: upgrage!!!    如果不能连续跳两个台阶怎么办?
     * 其实, 不能连续两个的话,  就是  跳两步后  必然是1不,  那就是  3步了,  这个题就转化为  每次只能 1,步和3步
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }
}
