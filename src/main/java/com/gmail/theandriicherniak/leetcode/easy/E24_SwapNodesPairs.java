package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 5/4/16.
 */
public class E24_SwapNodesPairs {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode new_head = head.next;

        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        ListNode prev = null;
        ListNode next = ptr2.next;

        while (ptr1 != null && ptr2 != null){
            if (prev != null) prev.next = ptr2;
            ptr2.next = ptr1;
            ptr1.next = next;
            prev = ptr1;

            ptr1 = next;
            if (ptr1 != null) ptr2 = ptr1.next;
            if (ptr2 != null) next = ptr2.next;
        }

        return new_head;
    }
}
