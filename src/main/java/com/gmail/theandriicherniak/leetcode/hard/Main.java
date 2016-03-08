package com.gmail.theandriicherniak.leetcode.hard;


import com.gmail.theandriicherniak.leetcode.hard.H23_MergeKSortedLists.*;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        H23_MergeKSortedLists s = new H23_MergeKSortedLists();

        ListNode n1 = s.new ListNode(1);
        ListNode n2 = s.new ListNode(2);
        ListNode n3 = s.new ListNode(3);
        ListNode n4 = s.new ListNode(4);
        ListNode n5 = s.new ListNode(5);
        ListNode n6 = s.new ListNode(6);
        ListNode n7 = s.new ListNode(7);
        ListNode n8 = s.new ListNode(8);
        ListNode n9 = s.new ListNode(9);
        ListNode n10 = s.new ListNode(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = null;

        ListNode result = s.mergeKLists(new ListNode[]{n1});
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}