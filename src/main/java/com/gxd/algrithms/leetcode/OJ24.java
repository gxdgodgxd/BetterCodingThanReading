package com.gxd.algrithms.leetcode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 16/9/24.
 */

public class OJ24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        this.getClass().getResourceAsStream("/SameTimeEnd");
        if (head == null || head.next == null) return head;
        ListNode p = swapPairs(head.next.next);
        head.next.next = head;
        ListNode res = head.next;
        head.next = p;
        return res;
    }

    public static void main(String[] args) {
        InputStream is = OJ24.class.getClass().getResourceAsStream("/abc.txt");
        if (is != null) {
            System.out.println("is not null");
        }else{
            System.out.println("is is null");
        }
        OJ24 oj = new OJ24();
        oj.swapPairsRecursive(null);

        List<Integer> list = new ArrayList();
        for (int i = 0; i <100; i++) {
            list.add(i);
        }
        for (int j=list.size()-1;j>=0;j--) {
            if (list.get(j) % 3 == 0) {
                list.remove(list.get(j));
            }
        }
    }

    //20160616 new method
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy,cur = head;
        while(cur!=null&&cur.next!=null){
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;

            prev=cur;
            cur=cur.next;
        }
        return dummy.next;
    }

}
