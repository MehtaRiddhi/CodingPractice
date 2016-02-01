package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/31/16.
 */
public class E21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode e1 = l1;
        ListNode e2 = l2;
        ListNode result = null;
        ListNode result_ptr = null;
        ListNode ptr = null;

        while (l1 != null || l2 != null){
            if (l1 != null && l2 == null){
                ptr = l1;
                l1 = l1.next;
            }
            if (l1 == null && l2 != null){
                ptr = l2;
                l2 = l2.next;
            }
            if (l1 != null && l2 != null){
                if (l1.val < l2.val) {
                    ptr = l1;
                    l1 = l1.next;
                }else{
                    ptr = l2;
                    l2 = l2.next;
                }
            }

            if (result == null){
                result = ptr;
            }else{
                result_ptr.next = ptr;
            }
            result_ptr = ptr;
        }

        return result;

    }
}
