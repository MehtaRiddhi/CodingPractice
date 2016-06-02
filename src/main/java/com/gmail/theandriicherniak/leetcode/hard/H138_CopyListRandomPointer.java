package com.gmail.theandriicherniak.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by andriicherniak on 6/1/16.
 */
public class H138_CopyListRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> cache = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode new_head = new RandomListNode(head.label);
        cache.put(head, new_head);

        Stack<RandomListNode> stack = new Stack<RandomListNode>();
        if (head.next != null) stack.push(head.next);
        if (head.random != null) stack.push(head.random);

        while (!stack.isEmpty()) {
            RandomListNode node = stack.pop();
            if (!cache.containsKey(node)) {

                RandomListNode copy = new RandomListNode(node.label);
                cache.put(node, copy);

                if (node.next != null) stack.push(node.next);
                if (node.random != null) stack.push(node.random);
            }
        }

        stack.push(head);
        HashSet<RandomListNode> visited = new HashSet<RandomListNode>();
        while (!stack.isEmpty()){
            RandomListNode node = stack.pop();
            RandomListNode copy = cache.get(node);

            if (!visited.contains(node)){
                visited.add(node);

                if (node.next != null) {
                    copy.next = cache.get(node.next);
                    stack.push(node.next);
                }
                if (node.random != null) {
                    copy.random = cache.get(node.random);
                    stack.push(node.random);
                }
            }
        }

        return new_head;
    }
}
