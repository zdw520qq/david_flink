package david.java.practice.algorithm.niuke;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午9:26 2021/2/20
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "=>" +fib(i));
        }
        System.out.println("========");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "=>" +fib1(i));
        }


    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n ==1) {
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public  static int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n ==1) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}

