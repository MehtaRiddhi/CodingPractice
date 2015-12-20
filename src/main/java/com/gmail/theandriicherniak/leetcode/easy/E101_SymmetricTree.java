package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 12/13/15.
 */
public class E101_SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isSymmetricHelper(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;

        return isSymmetricHelper(l.left, r.right) && isSymmetricHelper(l.right, r.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
}
