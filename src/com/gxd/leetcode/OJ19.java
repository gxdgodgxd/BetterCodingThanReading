package com.gxd.leetcode;

/**
 * Created by gxdgodgxd on 16/8/12.
 */


public class OJ19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            if (n-- <= 0) {
                slow = slow.next;
            }
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        OJ19.removeNthFromEnd(l1, 1);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}