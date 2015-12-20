package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 12/20/15.
 */
public class E83_DuplicatesSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode cur_n = head.next;
        ListNode prev_n = head;
        if (prev_n.val == cur_n.val) prev_n.next = null;

        while (cur_n != null){
            if (cur_n.val == prev_n.val) {
                prev_n.next = cur_n.next;
            }
            else {
                prev_n = cur_n;
            }
            cur_n = cur_n.next;
        }


        return head;

    }
}
