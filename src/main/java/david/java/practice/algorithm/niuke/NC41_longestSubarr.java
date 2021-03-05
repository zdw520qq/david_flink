package david.java.practice.algorithm.niuke;

import java.util.HashMap;

/**
 * @Description: 找到字符串的最长无重复子串
 *
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 *
 * @Author: David
 * @Date: Create in 下午11:59 2021/2/24
 */
public class NC41_longestSubarr {


    public static int maxLength (int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int curLength = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) >= start) {
                curLength = i - map.get(arr[i]);
                start = map.get(arr[i]) + 1;
            } else {
                curLength ++ ;
                maxLength = Math.max(maxLength, curLength);
            }
            map.put(arr[i], i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // int[] arr = {2,2,3,4,3,1,6,2,3,4};
        int[] arr = {1,2,3,4,5,6,2,2,3,4};
        int i = maxLength(arr);
        System.out.println(i);
    }


}
