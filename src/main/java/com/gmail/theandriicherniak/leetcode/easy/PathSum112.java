package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/27/15.
 */
public class PathSum112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean pathHelper(TreeNode root, int acc, int sum) {
        int cur_val = root.val + acc;

        if (root.left == null && root.right == null) {
            if (cur_val == sum) return true;
            else return false;

        } else {
            boolean left_path = false;
            boolean right_path = false;
            if (root.left != null) left_path = pathHelper(root.left, cur_val, sum);
            if (root.right != null) right_path = pathHelper(root.right, cur_val, sum);
            return left_path || right_path;
        }

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return pathHelper(root, 0, sum);
    }
}
