package com.gxd;

/**
 * Created by gxdgodgxd on 16/9/24.
 */

public class OJ23B {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwo(left, right);
    }
    private ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode newHead = head;
        while (left != null && right != null) {
            if (left.val  <= right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return newHead.next;
    }
}
