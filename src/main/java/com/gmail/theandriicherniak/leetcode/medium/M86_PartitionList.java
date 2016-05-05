package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/5/16.
 */
public class M86_PartitionList {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode head1 = null;
        ListNode ptr1 = null;

        ListNode head2 = null;
        ListNode ptr2 = null;

        ListNode ptr = head;

        while (ptr != null){
            if (ptr.val < x){
                if (head1 == null){
                    head1 = ptr;
                    ptr1 = ptr;
                }else {
                    ptr1.next = ptr;
                    ptr1 = ptr;
                }
            }else{
                if (head2 == null){
                    head2 = ptr;
                    ptr2 = ptr;
                }else {
                    ptr2.next = ptr;
                    ptr2 = ptr;
                }
            }
            ptr = ptr.next;
        }
        if (ptr1 != null) ptr1.next = null;
        if (ptr2 != null) ptr2.next = null;

        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ptr1.next = head2;
        return head1;
    }
}
