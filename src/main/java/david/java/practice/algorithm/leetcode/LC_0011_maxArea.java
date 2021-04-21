package david.java.practice.algorithm.leetcode;

/**
 * @Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * @Author: David
 * @Date: Create in 下午8:50 2021/3/21
 */
public class LC_0011_maxArea {
    /**
     * 题解:
     * 本题用双指针, 两个指针分别在两端, 两个指针缓缓向中间靠拢,直到两个指针重叠
     * 为了面积最大化,两个指针在向内移动的时候, 要先比较下,两个指针对应的值, 值小的移动.
     * 这样记录过程中的面积最大的值
     *
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max((r - l) * Math.min(height[l], height[r]), area);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        LC_0011_maxArea maxArea = new LC_0011_maxArea();
        int i = maxArea.maxArea(test);
        System.out.println(i);
    }
}
