package david.java.practice.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 下午8:26 2021/4/13
 */
public class Test001 extends DavidBase{
    public static void main(String[] args) {
        int fib = fib(3);
        System.out.println(fib);
    }

    public static int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int first = 1;
        int second = 2;
        if (n == 1) {
            return first;
        }
        if (n == 2) {
            return second;
        }

        int count = 3;

        while (count < n) {
            int tmp = second;
            second = second + first;
            first = tmp;
            count++;
        }

        return first + second;


    }




}
