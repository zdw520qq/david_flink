package david.java.practice.algorithm.leetcode;

import java.util.Stack;

/**
 * @Description: 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead'0'操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * @Author: David
 * @Date: Create in 上午10:38 2021/6/6
 */
public class O_09_CQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public O_09_CQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (in.isEmpty() && out.isEmpty()) {
            return -1;
        }
        if (out.isEmpty()) {
            in2Out();
        }
        return out.pop();
    }

    private void in2Out() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
