package com.gxd.leetcode;

/**
 * Created by gxdgodgxd on 17/6/16.
 */

public class OJ82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(Integer.MAX_VALUE); // 头结点
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            boolean duplicated = false;
            while (cur.next != null && cur.val == cur.next.val) {
                duplicated = true;
                cur = cur.next;
            }
            if (duplicated) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
