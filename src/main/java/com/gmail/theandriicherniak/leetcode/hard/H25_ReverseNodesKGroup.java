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
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int cnt = 0;
        ListNode ptr = head;
        ListNode start = head;
        ListNode end = null;

        while (ptr != null){
            cnt ++;
            if (cnt == k){
                reverseLinks(start, ptr);
                end = ptr;
                cnt = 0;
                ptr = ptr.next;
                start = ptr;
            }else ptr = ptr.next;
        }
        return head;
    }
}
