package com.gxd.essentials.linkedlist;

/**
 * Created by gxdgodgxd on 17/3/8.
 */
public class E1_2_2 {

    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenDummy = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenDummy;
        return head;
    }

}
