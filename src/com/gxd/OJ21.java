package com.gxd;

/**
 * Created by gxdgodgxd on 16/8/12.
 */

public class OJ21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l2 == null) {
            p.next = l1;
        }
        if (l1 == null) {
            p.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        OJ21.mergeTwoLists(l1, l2);

    }
}

