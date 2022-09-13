package com.xgh.doublepointer.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xgh 2022/8/26
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(val);
        ListNode r = next;
        while (r != null) {
            list.add(r.val);
            r = r.next;
        }
        return String.valueOf(list);
    }

    public static ListNode arrayToLink(int[] arr) {
        if (arr == null && arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode last = head;
        for (int i = 1; i < arr.length; i++) {
            last.next = new ListNode(arr[i]);
            last = last.next;
        }
        return head;
    }
}
