package david.java.practice.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 用队列实现栈
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * @Author: David
 * @Date: Create in 下午8:37 2021/6/11
 */
public class LC_0225_mystack {

    Deque<Integer> deque;

    /**
     * Initialize your data structure here.
     */
    public LC_0225_mystack() {
        deque = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        deque.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return deque.pollFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return deque.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}
