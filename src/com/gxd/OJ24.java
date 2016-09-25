package com.gxd;

/**
 * Created by gxdgodgxd on 16/9/24.
 */

public class OJ24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = swapPairs(head.next.next);
        head.next.next = head;
        ListNode res = head.next;
        head.next = p;
        return res;
    }
}
