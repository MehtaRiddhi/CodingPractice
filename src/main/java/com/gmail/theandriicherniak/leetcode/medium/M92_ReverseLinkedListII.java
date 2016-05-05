package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/5/16.
 */
public class M92_ReverseLinkedListII {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        if (head.next == null) return head;
        if (m == n) return head;

        ListNode ptr = head;
        ListNode start = null, end = null, prev = null, prevStart = null, nextEnd = null;

        int cnt = 0;
        while (ptr != null && cnt < n){
            cnt ++;
            if (m == cnt) {
                start = ptr;
                prevStart = prev;
            }
            if (n == cnt) {
                end = ptr;
                nextEnd = ptr.next;
            }

            prev = ptr;
            ptr = ptr.next;
        }

        end.next = null;
        if (prevStart != null) prevStart.next = null;

        ListNode ptr1, ptr2, ptr3;
        ptr1 = start;
        ptr2 = start.next;
        ptr3 = ptr2.next;
        start.next = null;

        while (ptr2 != null){
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr3;
            if (ptr3 != null) ptr3 = ptr3.next;
        }


        start.next = nextEnd;
        if (prevStart == null) return end;
        prevStart.next = end;
        return head;
    }
}
