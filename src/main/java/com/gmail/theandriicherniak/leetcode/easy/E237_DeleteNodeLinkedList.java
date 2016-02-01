package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/31/16.
 */
public class E237_DeleteNodeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        // we cant delete current node. thus move value from the next node, and delete next node
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
