package com.gmail.theandriicherniak.leetcode;

/**
 * Created by andriicherniak on 11/27/15.
 */

import java.util.*;

public class BinaryTreeLevelOrderTraversal102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new LinkedList<List<Integer>>();

    public void helper(LinkedList<TreeNode> input_level){
        List<Integer> level_values = new LinkedList<Integer>();

        LinkedList<TreeNode> level_buffer = new LinkedList<TreeNode>();

        for (TreeNode node : input_level){
            if (node.left != null) level_buffer.add(node.left);
            if (node.right != null) level_buffer.add(node.right);
            level_values.add(node.val);
        }
        result.add(level_values);
        if (level_buffer.size() > 0) helper(level_buffer);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        LinkedList<TreeNode> level_buffer = new LinkedList<TreeNode>();
        level_buffer.add(root);
        helper(level_buffer);
        return result;
    }
}
