package david.java.practice.algorithm.zijie;

import david.java.practice.algorithm.DavidBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 统计一共有多少个逆序对, 逆序对指定是前一个比后一个数大,即降序了 ,比如  7,6,5,4,3,2,1,0  一个有7个
 * @Author: David
 * @Date: Create in 上午11:37 2021/5/13
 */
public class ReservePair extends DavidBase {

    public static int count = 0;

    /**
     * 题解:  利用归并排序, 在合并的时候, 统计count, 两个数组,当右边的向左边排序的时候,越过了 左边的几个就记录下来, 然后,用新的顺序跟后面的比
     * 逻辑参考 https://cloud.tencent.com/developer/article/1673679
     */
    public static int[] mergeSortCount(int[] ints, int start, int end) {
        if (start == end) {
            return new int[]{ints[start]};
        }
        int mid = (start + end) / 2;
        int[] left = mergeSortCount(ints, start, mid);
        int[] right = mergeSortCount(ints, mid + 1, end);
        int[] newArr = new int[left.length + right.length];

        int i = 0, l = 0, r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                newArr[i++] = left[l++];
            } else {
                newArr[i] = right[r];
                // 此处是关键, 比如  1,4    与   2,3  首先每个数组肯定是有序的,因为递归排序了
                // 最后 肯定是  1,2,3,4    2 由下标2 变为了 新数组的下标 1, 前进了一位,说明有一个逆序对
                count += left.length + r - i;
                i++;
                r++;
            }
        }
        while (l < left.length) {
            newArr[i++] = left[l++];
        }
        while (r < right.length) {
            newArr[i] = right[r];
            i++;
            r++;
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 8, 7, 0};
        int[] ints = mergeSortCount(arr, 0, 7);
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(count);

    }

}

