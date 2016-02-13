package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/13/16.
 */
public class E19_RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode ptr1 = head;
        ListNode ptr2 = head;
        int counter_n = 0;
        while ((counter_n < n) && (ptr1.next != null)){
            ptr1 = ptr1.next;
            counter_n ++;
        }

        while (ptr1.next != null){
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        if (ptr2.next == null) return null;
        if (ptr2.next != null && counter_n < n) return ptr2.next;

        ptr2.next = ptr2.next.next;
        return head;
    }
}
