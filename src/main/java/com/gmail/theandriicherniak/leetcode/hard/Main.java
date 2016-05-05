package com.gmail.theandriicherniak.leetcode.hard;

public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running hard examples");

        H25_ReverseNodesKGroup group = new H25_ReverseNodesKGroup();
        H25_ReverseNodesKGroup.ListNode head = null;
        H25_ReverseNodesKGroup.ListNode ptr = null;

        for (int i = 1; i <= 100; i++){
            H25_ReverseNodesKGroup.ListNode node = group.new ListNode(i);
            if (head == null) {
                head = node;
                ptr = node;
            }
            else {
                ptr.next = node;
                ptr = node;
            }
        }

        group.reverseKGroup(head, 5);
    }
}
