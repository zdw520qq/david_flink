package david.java.practice.algorithm.leetcode;

/**
 * @Description: 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数dividend除以除数divisor得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * @Author: David
 * @Date: Create in 下午8:47 2021/4/26
 */
public class LC_0029_divide {


    /**
     * 题解:不用用 除法, 那就自己实现个除法吧,为了效率, 可以自己做了类似于二分法的除法, 把除数膨胀n倍,使得 其恰好小于被除数, 如果在膨胀就大于被除数了,
     * 此时的结果也要记录下来.
     * <p>
     *
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }


        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int oppositeValue = binaryDiv(dividend, divisor);
        //因为自定义除法是负数,所以在这里先转过来了
        sign = -sign;

        int value = sign == 1 ? oppositeValue :oppositeValue ==  Integer.MIN_VALUE ? Integer.MAX_VALUE : -oppositeValue;

        return value;

    }

    /**
     * 为了防止溢出, a, b 都转为了负数, 记住渣后的结果也是负数, 需要 转成正数,  所以需要判断 ,是不是 integer.minvalue
     */
    private static int binaryDiv(int a, int b) {
        if (a > b) {
            return 0;
        }
        int expendB = b;
        int count = -1;
        //这一步就是在找最大的除数, 类似于二分法
        // 比如 25/2 = 8
        // 25 / 4  * 2 , 25 / 8 * 4  ,25 /16 * 8 = 8
        // (25-16)=9   9/2 , 9/4 *2,   9 /8 * 4 = 4
        // 1 < 2  = 0
        // => 8 + 4 = 12
        // 此处需要注意  expend 别溢出
        while (expendB > Integer.MIN_VALUE/2 && (expendB + expendB) >= a) {
        // while (expendB >= a >> 1) { 不能这么做,会出错,损失精度
            expendB = expendB + expendB;
            count = count + count;
        }
        // 这里的递归的 除数是b ,因为下一轮还要从 基数开始
        return count + binaryDiv(a - expendB, b);
    }

    public static void main(String[] args) {
        // int a = -2147483648;
        int a = 2147483647;
        int b = 2;
        int i = divide(a, b);
        System.out.println(i);

        // System.out.println(4 >> 1);
    }

}
