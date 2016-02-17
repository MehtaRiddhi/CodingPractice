package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/16/16.
 */
public class E234_PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int N = 0;

        ListNode ptr = head;
        ListNode half_list = null;
        ListNode ptr2 = null;

        while (ptr != null){
            N ++;
            ptr = ptr.next;
        }

        if (N == 1) return true;
        int mid_point = N / 2;
        ptr = head;
        int counter = 0;

        while (counter < mid_point){
            ptr = ptr.next;
            counter ++;
        }

        if (N % 2 == 1) ptr = ptr.next;
        while (ptr != null){
            ptr2 = ptr;
            ptr = ptr.next;
            ptr2.next = half_list;
            half_list = ptr2;
        }

        boolean result = true;
        ptr = head;
        ptr2 = half_list;
        counter = 0;

        while (result && counter < N / 2){
            if (ptr.val != ptr2.val) result = false;
            ptr = ptr.next;
            ptr2 = ptr2.next;
            counter ++;
        }

        return result;
    }
}
