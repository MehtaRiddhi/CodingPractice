package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/3/16.
 */
public class E206_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode new_list = head;
        ListNode cur_element = head.next;
        head.next = null;

        ListNode next_element;


        while (cur_element != null){
            next_element = cur_element.next;
            cur_element.next = new_list;
            new_list = cur_element;

            cur_element = next_element;
        }
        return new_list;
    }
}
