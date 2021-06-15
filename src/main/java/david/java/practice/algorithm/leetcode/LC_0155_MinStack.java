package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。     // 看题意是,不需要返回
 * top()—— 获取栈顶元素。      // 根据题解就是 peek  (垃圾, 题都说不明白)
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class LC_0155_MinStack extends DavidBase {
    Stack<Integer> value;
    Stack<Integer> min;
    int size = 0;

    /**
     * 题解: push 添加, pop 删除不返回, top 返回栈顶,  getMin ()  获取当前中最小的,但是不删除
     * 用两个stak, 一个stack记录数据, 另一个用来 记录没一个数据进来后的最小值, 其实,就是进来的数大 则, 在装一次上一次的最小值.
     * 本题不考虑 数据空的时候, pop, 写的时候当时注意. 也懒的改了
     */
    public LC_0155_MinStack() {
        value = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        value.push(val);
        min.push(min.peek() < val ? min.peek() : val);
        size++;
    }

    public void pop() {
        if (size > 0) {
            value.pop();
            min.pop();
            size--;
        }
    }

    public int top() {
        return  value.peek();
    }

    public int getMin() {
        return size > 0 ?min.peek() : -1;
    }

    public static void main(String[] args) {
        LC_0155_MinStack minStack = new LC_0155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        int[] arr = {1,2,3,4,5};
        int[] ints = Arrays.copyOf(arr, 10);
        printArr(ints);

    }
}
