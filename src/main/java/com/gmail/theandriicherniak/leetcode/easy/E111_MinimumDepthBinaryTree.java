package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/26/15.
 */
public class E111_MinimumDepthBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int treeDepth(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right != null) return treeDepth(root.right) + 1;
        if (root.left != null && root.right == null) return treeDepth(root.left) + 1;
        if (root.left != null && root.right != null) return Math.min(treeDepth(root.left), treeDepth(root.right)) + 1;

        if (root.left == null && root.right == null) return 1;
        return 0;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return treeDepth(root.right) + 1;
        if (root.left != null && root.right == null) return treeDepth(root.left) + 1;
        if (root.left != null && root.right != null) return Math.min(treeDepth(root.left), treeDepth(root.right)) + 1;

        if (root.left == null && root.right == null) return 1;
        return 0;
    }
}
