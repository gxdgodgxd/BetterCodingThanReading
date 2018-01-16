package com.gxd.essentials.linkedlist;

/**
 * Created by gxdgodgxd on 18/1/3.
 */
public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, post = null;
        while (head!=null){
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListFromNum(115);
        ReverseLinkedList.reverse(l1).print();
    }
}
