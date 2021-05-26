package david.java.practice.algorithm.leetcode;

import david.java.practice.algorithm.DavidBase;

/**
 * @Description:
 * @Author: David
 * @Date: Create in 上午8:57 2021/5/17
 */
public class LC_0141_hasCycle extends DavidBase {
    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if (f == s) {
                return true;
            }
        }

        return false;

    }
}
