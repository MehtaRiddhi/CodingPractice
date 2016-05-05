package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/16/16.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("runing easy ");

        E24_SwapNodesPairs swap = new E24_SwapNodesPairs();
        E24_SwapNodesPairs.ListNode head = null;
        E24_SwapNodesPairs.ListNode ptr = null;

        for (int i = 1; i <= 10; i++){
            E24_SwapNodesPairs.ListNode node = swap.new ListNode(i);
            if (head == null) {
                head = node;
                ptr = node;
            }
            else {
                ptr.next = node;
                ptr = node;
            }
        }

        ptr = swap.swapPairs(head);

        while (ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
}
