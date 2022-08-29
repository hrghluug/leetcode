package com.xgh.doublepointer;

import com.xgh.doublepointer.Entity.ListNode;

/**
 * @author xgh 2022/8/29
 */
public class Q141 {
    public boolean q141(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next, low = head.next;
        while (fast != low) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return true;
    }
}
