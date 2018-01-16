package com.gxd.essentials.linkedlist;

/**
 * Created by gxdgodgxd on 17/3/8.
 */
public class E1_2_5 {

    public ListNode partition(ListNode head, int x) {
        ListNode left_dummy = new ListNode(0);
        ListNode left_tail = left_dummy;
        ListNode right_dummy = new ListNode(0);
        ListNode right_tail = right_dummy;

        while (head != null) {
            if (head.val < x) {
                left_tail.next = head;
                left_tail = head;
                head = head.next;
            }else {
                right_tail.next = head;
                right_tail = head;
                head = head.next;
            }
        }
        left_tail.next = right_dummy.next;
        //很重要,否则死循环
        right_tail.next = null;
        return left_dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        E1_2_5 e = new E1_2_5();
        e.partition(l1, 3).print();

    }

}
