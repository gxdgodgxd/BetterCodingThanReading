package com.gxd;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gxdgodgxd on 16/9/24.
 */
public class OJ23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return heap(lists);
    }
    private ListNode heap(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null)
                pq.offer(head);
        }
        ListNode res = new ListNode(0);
        ListNode resHead = res;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            res.next = cur;
            res = res.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return resHead.next;
    }
}
