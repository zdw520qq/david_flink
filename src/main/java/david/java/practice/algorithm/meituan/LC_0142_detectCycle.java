package david.java.practice.algorithm.meituan;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 * @Author: David
 * @Date: Create in 下午8:49 2021/5/17
 */
public class LC_0142_detectCycle extends DavidBase {


    /**
     * 题解: 这个解法很精巧了,利用了数学推导
     *
     * 示例:
     *          a
     *  /-------/\----\
     *  1 -> 2 -> 3 -> 4 -> 5 -> 6      \
     *                     /       \    |
     *                    9         7   | b
     *                     \       /    |
     *                         8       /
     *
     * 如图: 一个链表一共9个节点, 其中 第5个是入口,  前4个为直路, 我们 标记为a,    环的部分5个节点,我们成为b
     * 我们用快慢指针, s 一次走一步, f 一次走2步
     * 那么,肯定有
     *  f = 2s      <-- ①
     *  因为f与s最终相遇,那么 f 肯定比 s多走了 n圈, 即 n 个b
     *  f - s = nb  <-- ②
     *  由 ①②  推出=>
     *  s = nb      <-- ③
     *
     *  现在换另一种思维:
     *  如果我们要 s 走到 环入口处 ,那么一共要多少步呢? 我们设为 k步, 因为到环入口处, 那么s 肯定在 环内走的是完整的,那么
     *  k = a + nb  <-- ④
     *  由 ③和④ =>
     *  k = a + s   <-- ⑤
     *
     *  ③是f与s 相遇的地方, 也就是说, s 在相遇后再走 a步, 就到了 入口处
     *  但是a是未知的,所以,我们让 f == head, 然后 f走a步 ,也会到入口处, 即与s 会再次相遇.
     *  所以,再次相遇的点就是 入口.
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                break;
            }
        }
        if (f != s) {
            return null;
        }
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
