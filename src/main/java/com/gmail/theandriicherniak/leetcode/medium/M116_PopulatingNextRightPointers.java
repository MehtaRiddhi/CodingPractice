package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/28/16.
 */
public class M116_PopulatingNextRightPointers {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode tmp;

        while (root.left != null){
            tmp = root;
            while (tmp != null){
                tmp.left.next = tmp.right;
                if (tmp.next != null) tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            root = root.left;
        }
    }
}
