package com.xgh.doublepointer;

import com.xgh.doublepointer.Entity.ListNode;

import java.util.List;

/**
 * @author xgh 2022/8/31
 */
public class Q82 {
    public static void main(String[] args) {
        ListNode node = ListNode.arrayToLink(new int[]{1,1});
        System.out.println(deleteDuplicates(node));
    }

    public  static  ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(Integer.MAX_VALUE);
        ListNode last = node;
        while (head!=null&&head.next != null) {
            if (head.val!=head.next.val){
                last.next=head;
                last=head;
            }else {
                head=head.next;
                while (head.next != null&&head.val==head.next.val)
                {
                    head=head.next;
                }
            }
            head=head.next;
        }
        last.next=head;
        return node.next;
    }

    /**
     * 删除重复的节点,保留一个
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }


}
