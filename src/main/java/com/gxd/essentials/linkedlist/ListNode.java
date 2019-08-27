package com.gxd.essentials.linkedlist;

/**
 * Created by gxdgodgxd on 17/3/8.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print(){
        ListNode tmp = this;
        while (tmp != null) {
            System.out.print(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.print("null");
    }

    public static ListNode getListFromNum(int x){
        ListNode head = null,pre = null;
        while (x != 0) {
            pre = new ListNode(x%10);
            pre.next = head;
            head = pre;
            x = x/10;
        }
        return head;
    }
}
