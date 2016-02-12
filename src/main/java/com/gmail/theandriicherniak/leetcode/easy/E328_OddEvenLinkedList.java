package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/11/16.
 */
public class E328_OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void addToList(ListNode[] signature){
        if (signature[1] == null){
            signature[1] = signature[0];
            signature[2] = signature[0];
        }else{
            signature[2].next = signature[0];
            signature[2] = signature[0];
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode [] odd_elements_signature = new ListNode[]{null, null, null};
        ListNode [] even_elements_signature = new ListNode[]{null, null, null};

        ListNode ptr = head;
        ListNode cur_element = null;

        int element_number = 0;
        while (ptr != null){
            cur_element = ptr;
            ptr = ptr.next;
            cur_element.next = null;

            element_number ++;
            if (element_number % 2 == 1){
                odd_elements_signature[0] = cur_element;
                addToList(odd_elements_signature);
            }else{
                even_elements_signature[0] = cur_element;
                addToList(even_elements_signature);
            }
        }
        odd_elements_signature[2].next=even_elements_signature[1];
        return odd_elements_signature[1];
    }
}
