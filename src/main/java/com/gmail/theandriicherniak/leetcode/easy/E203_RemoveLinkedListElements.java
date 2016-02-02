package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/31/16.
 */
public class E203_RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
            ListNode ptr = head;
            ListNode filtered_ptr = null;
            ListNode result = null;
            int tmp_val;

            if (head == null) return null;

            while (ptr != null){
                tmp_val = ptr.val;
                if (tmp_val != val){
                    if (filtered_ptr == null){
                        result = head;
                        filtered_ptr = head;
                        filtered_ptr.val = tmp_val;
                    }else{
                        filtered_ptr = filtered_ptr.next;
                        filtered_ptr.val = tmp_val;
                    }
                }
                ptr = ptr.next;
            }
            if (filtered_ptr != null) filtered_ptr.next = null;

            return result;
    }
}
