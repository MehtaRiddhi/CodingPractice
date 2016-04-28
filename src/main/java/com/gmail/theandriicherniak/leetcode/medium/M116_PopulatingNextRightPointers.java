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

    private void connectTwo(TreeLinkNode left, TreeLinkNode right){
        while (left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root != null){
            connectTwo(root.left, root.right);
            connect(root.left);
            connect(root.right);
        }
    }
}
