package david.java.practice.algorithm.niuke;

import david.java.practice.algorithm.Base;

import java.util.HashMap;

/**
 * @Description:给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 * @Author: David
 * @Date: Create in 下午11:39 2021/2/21
 */
public class NC61_twoNumSum extends Base {
    /**
     * 结题思路:
     * 肯定不能排序, 可以hash, 先for循环将数组的数组存入map, 值为key, 索引为value,  然后在for循环 然后用map.get(target-num1) 是否为null
     *
     * 方案优化:
     * 使用一个for即可, 在for中如果map.get(target-num1) 存在, 则返回, 不存在则把其加入map
     * 因为题目中说了,肯定有一对, 所以在for前期,如果错过了正确的答案,也没关系,因为 循环到num2时, map.get(targe-num2)也是一样的
     * 并且, 肯定是 num2 后出来,
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])) {
                return new int[]{map.get(target-numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
