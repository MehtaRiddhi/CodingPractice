package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/4/16.
 */
public class H25_ReverseNodesKGroup {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }

    private void reverseLinks(ListNode start, ListNode end){
        ListNode ptr1 = null, ptr2 = null, ptr3 = null;
        if (end != null) end.next = null;
        ptr1 = start;
        if (ptr1 != null && ptr1.next != null) ptr2 = ptr1.next;
        start.next = null;

        while (ptr2 != null){
            ptr3 = ptr2.next;
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr3;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int cnt = 0;
        ListNode new_head = null;

        ListNode ptr = head;
        ListNode start = head;
        ListNode afterEnd, beforeStart = null;

        while (ptr != null){
            cnt ++;
            if (cnt == k){
                afterEnd = ptr.next;

                reverseLinks(start, ptr);
                if (new_head == null) new_head = ptr;
                if (beforeStart != null) {
                    beforeStart.next = ptr;
                }

                beforeStart = start;
                cnt = 0;
                ptr = afterEnd;
                start = ptr;

            }else ptr = ptr.next;
        }

        if (start != null){
            if (beforeStart != null) beforeStart.next = start;
        }

        if (new_head == null) return head;
        return new_head;
    }
}
