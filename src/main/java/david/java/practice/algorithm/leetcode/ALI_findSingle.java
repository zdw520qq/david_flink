package david.java.practice.algorithm.leetcode;

/**
 * @Description:  阿里云一面
 * //有一个整数序列，整数都是连续两次出现，但其中有一个整数只出现了一次，请写算法找出出现一次的整数。
 * //例如 1，1，34，34，9，3，3，其中9只出现了一次
 * // {1}
 * //  1 1 2 2 3
 * //  1 2 2 3 3
 * <p>
 * // 1 1 2
 * // 1 2 2
 * @Author: David
 * @Date: Create in 上午9:59 2021/6/22
 */
public class ALI_findSingle {

    /**
     * 题解:
     * 方法一: 用hashMap   时间复杂度 n,  空间复杂度 n;
     * 方法二: 用异或   a ^ b ^ a = b, 时间复杂度 n,  空间复杂度 1;
     * 方法三: 二分法, arr[mid] = arr[mid +1] || arr[mid-1],  来控制往哪边计算 时间复杂度 log n,  空间复杂度 1
     */
    public static Integer findSingle(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }


        if (arr.length == 1) {
            return arr[0];
        }

        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            int single = ((end - start) / 2) % 2;

            // todo 边界值

            if (single == 1) {
                if (arr[mid] == arr[mid + 1]) {
                    end = mid - 1;
                } else if (arr[mid] == arr[mid - 1]) {
                    start = mid + 1;
                } else {
                    return arr[mid];
                }

            } else {
                if (arr[mid] == arr[mid + 1]) {
                    start = mid + 2;
                } else if (arr[mid] == arr[mid - 1]) {
                    end = mid - 2;
                } else {
                    return arr[mid];
                }
            }
        }

        return arr[start];
    }

}
