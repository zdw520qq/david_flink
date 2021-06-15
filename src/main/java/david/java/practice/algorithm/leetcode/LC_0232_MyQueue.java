package david.java.practice.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 用栈实现队列
 * <p>
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * @Author: David
 * @Date: Create in 上午10:41 2021/5/17
 */
public class LC_0232_MyQueue {
    /**
     * 题解: in 用来  进来,  out 用来出
     *
     */
    private Stack<Integer> in;
    private Stack<Integer> out;


    public LC_0232_MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.isEmpty()) {
            dump();
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.isEmpty()) {
            dump();
        }
        // return out.peek();
        LinkedList<Integer> integers = new LinkedList<>();
        return integers.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void dump() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
