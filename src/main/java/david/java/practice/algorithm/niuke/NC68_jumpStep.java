package david.java.practice.algorithm.niuke;

import david.java.practice.algorithm.Base;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Author: David
 * @Date: Create in 下午10:09 2021/2/21
 */
public class NC68_jumpStep extends Base {




    /**
     * 结题思路: 其实这就是一个斐波那契数列! 为何,听我解释...
     * 比如台阶数为6, 那么青蛙可以从 5 跳到 6, 也可以从 4 跳到 6, 因此,青蛙从1跳到6的跳法可以转变为求 青蛙从1跳到4的跳法加上从1跳到5的跳法,
     * 抽象一下, 也就是,青蛙从1跳到n的跳法可以转变为,求青蛙从1跳到n-2的跳法加上从1跳到n-1的跳法, 这不就是斐波那契么?
     * <p>
     * 这个斐波那契 当 n=1 返回1, n=2 返回2
     *
     * @param n
     * @return
     */
    public static int jumpStep(int n) {
        return fib1(n);
    }

    public static int fibRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fib1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static int fib2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] a = new int[target];
        a[0] = 1;
        a[1] = 2;
        for (int i = 3; i <= target; i++) {
            a[i - 1] = a[i - 2] + a[i - 3];
        }
        return a[target - 1];
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "=> " + jumpStep(i));
        }
    }
}
