package com.gxd.essentials.linkedlist;

/**
 * Created by gxdgodgxd on 18/1/3.
 */
public class AddLinkedList {

    public static ListNode addTwoLinkedList(ListNode a, ListNode b) {
        ListNode reva = ReverseLinkedList.reverse(a);
        ListNode revb = ReverseLinkedList.reverse(b);

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int sum = 0;
        while (reva != null || revb != null || sum>=10) {
            sum /= 10;
            if (reva != null) {
                sum += reva.val;
                reva = reva.next;
            }
            if (revb != null) {
                sum += revb.val;
                revb = revb.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        return ReverseLinkedList.reverse(dummy.next);
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListFromNum(999);
        ListNode l2 = ListNode.getListFromNum(1);
        AddLinkedList.addTwoLinkedList(l1,l2).print();

    }
}
