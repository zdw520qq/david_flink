package david.java.practice.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Description: 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *
 * 1 <= nums.length <= 100
 *
 * @Author: David
 * @Date: Create in 上午10:27 2021/6/18
 */
public class LC_0179_largestNumber {

    /**
     * 题解: 主要是要比较  每个数高位的大小, 高位一样比较低位, 比如 34  与  3    , 高位都为3, 则看低位,一个4,一个3 所以34 大
     */
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) {
            sb.append(nums[0]);
            return sb.toString();
        }

        //包装一下,否则 Arrays.sort( ) 里面lambda的 compare 无法比较.
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        //排序的逻辑, 比如两个数  111,22,  比较 111*100 + 22 = 11122  与 22 * 1000 + 111 = 22111 的大小
        //为了防止数字溢出,  我用了long
        Arrays.sort(arr, (x, y) -> {
            long sx = 10;
            long sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }

            return -Double.compare(x * sy + y, y * sx + x);
        });

        //此种情况是 都为0, 因为是降序排序
        if (arr[0] == 0) {
            return "0";
        }

        for (Integer integer : arr) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_0179_largestNumber ll = new LC_0179_largestNumber();
        int[] arr = {10,2};
        String s = ll.largestNumber(arr);
        System.out.println(s);

    }
}
