package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/26/15.
 */
public class BalancedBinaryTree110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int treeHeight(TreeNode root) {
        if (root == null) return 0;

        int l = treeHeight(root.left);
        int r = treeHeight(root.right);

        if (l == -1 || r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;

        return Math.max(l, r) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int l = treeHeight(root.left);
        int r = treeHeight(root.right);

        if (l == -1 || r == -1) return false;
        if (Math.abs(l - r) > 1) return false;

        return true;
    }
}