package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/11/16.
 */
public class E270_ClosestBinarySearchTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        int best_value = root.val;
        double best_distance = Math.abs(best_value - target);
        double cur_distance = 0.0;

        TreeNode cur_root = root;
        while (cur_root != null){
            cur_distance = Math.abs(cur_root.val - target);
            if (cur_distance < best_distance){
                best_distance = cur_distance;
                best_value = cur_root.val;
            }
            if (target < cur_root.val) cur_root = cur_root.left;
            else cur_root = cur_root.right;
        }

        return best_value;
    }
}
