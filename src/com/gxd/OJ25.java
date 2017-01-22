package com.gxd;

/**
 * Created by gxd4297 on 2016/9/26.
 */

public class OJ25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode[] group = new ListNode[k + 1];
        dummy.next = head;
        group[0] = dummy;
        boolean flag = true;
        while (flag) {
            for (int i = 1; i < k + 1; i++) {
                if (group[i - 1].next != null) {
                    group[i] = group[i - 1].next;
                }else{
                    flag = false;
                    break;
                }
            }
            if (flag) {
                group[0].next = group[k];
                group[1].next = group[k].next;
                for (int i = k; i > 1 ; i--) {
                    group[i].next = group[i - 1];
                }
                group[0] = group[1];
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode p = OJ25.reverseKGroup(l1, 4);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
