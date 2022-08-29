package com.xgh.doublepointer;

import com.xgh.doublepointer.Entity.ListNode;
import org.junit.Test;

/**
 * @author xgh 2022/8/29
 */
public class Q61 {
    @Test
    public void test(){
        ListNode listNode = ListNode.arrayToLink(new int[]{1, 2});
        rotateRight(listNode,2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode node = new ListNode(), l = node, r = node, temp;
        node.next = head;
        while (k > 0) {
            if (r.next != null){
                r = r.next;
            }else {
                r=head;
            }
            k--;
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        if (l==node){
            return head;
        }
        temp = l.next;
        l.next = null;
        r.next = head;
        return temp;
    }
}
