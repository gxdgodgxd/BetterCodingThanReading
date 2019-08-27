package com.gxd.algrithms.leetcode;

/**
 * Created by gxdgodgxd on 17/6/19.
 */

public class OJ206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p,q,tail;
        p = head;
        q = p.next;
        tail = null;
        p.next = null;

        while(tail!=null){
            tail = q.next;
            q.next = p;
            p = q;
            q = tail;
        }
        return p;
    }
}
