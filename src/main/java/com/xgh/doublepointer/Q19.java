package com.xgh.doublepointer;


import com.xgh.doublepointer.Entity.ListNode;
import org.junit.Test;

/**
 * @author xgh 2022/8/26
 */
public class Q19 {
    @Test
    public void test() {
        ListNode node = ListNode.arrayToLink(new int[]{1, 2, 3, 4, 5});
        System.out.println(removeNthFromEnd(node, 6));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next=head;
        ListNode r = node, l = node;
        while (n > 0 && r.next != null) {
            r = r.next;
            n--;
        }
        if (n>0){
            return head;
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return node.next;

    }


}
