package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/1/16.
 */
public class E160_IntersectionTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        ListNode tmp = null;
        int lenA = 1;
        int lenB = 1;


        while (ptrA.next != null){
            ptrA = ptrA.next;
            lenA ++;
        }
        while (ptrB.next != null){
            ptrB = ptrB.next;
            lenB ++;
        }
        if (ptrA != ptrB) return null;

        if (headA == headB) return headA;

        ptrA = headA;
        ptrB = headB;

        while (lenA > lenB){
            ptrA = ptrA.next;
            lenA --;
        }
        while (lenB > lenA){
            ptrB = ptrB.next;
            lenB --;
        }
        while (ptrA != ptrB){
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return ptrA;

    }
}
