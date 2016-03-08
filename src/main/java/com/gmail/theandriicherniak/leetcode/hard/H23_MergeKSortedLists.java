package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/7/16.
 */
import java.util.*;

public class H23_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class listNextValue{
        int val;
        int listId;
        public listNextValue(int valP, int listIdP){
            val = valP;
            listId = listIdP;
        }
    }

    public class listValueComparator implements Comparator<listNextValue> {
        public int compare(listNextValue v1, listNextValue v2){
            if (v1.val > v2.val) return 1;
            if (v1.val < v2.val) return -1;
            return 0;
        }
    }

    ListNode result_head;
    ListNode result_tail;

    private void addElement(ListNode n){
        if (result_head == null) result_head = n;
        if (result_tail != null) result_tail.next = n;
        result_tail = n;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        result_head = null;
        result_tail = null;

        if (lists == null) return result_head;
        int N = lists.length;
        if (N == 0) return result_head;

        PriorityQueue<listNextValue> q = new PriorityQueue<listNextValue>(N, new listValueComparator());

        for (int i = 0; i < N; i++){
            if (lists[i] != null){
                q.add(new listNextValue(lists[i].val, i));
            }
        }

        while (!q.isEmpty()){
            listNextValue v = q.remove();
            addElement(lists[v.listId]);
            lists[v.listId] = lists[v.listId].next;
            if (lists[v.listId] != null){
                q.add(new listNextValue(lists[v.listId].val, v.listId));
            }
        }

        return result_head;
    }
}
