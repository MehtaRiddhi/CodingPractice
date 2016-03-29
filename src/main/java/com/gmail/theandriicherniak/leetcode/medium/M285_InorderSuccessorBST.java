package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Stack;

/**
 * Created by andriicherniak on 3/29/16.
 */
public class M285_InorderSuccessorBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode getMin(TreeNode x){
        if (x == null) return null;
        if (x.left == null) return x;
        return getMin(x.left);
    }

    private void getParents(TreeNode root, TreeNode p, Stack<TreeNode> memory){
        if (root.val > p.val) memory.push(root);
        if (p.val < root.val) getParents(root.left, p, memory);
        if (p.val > root.val) getParents(root.right, p, memory);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) return getMin(p.right);
        else {
            Stack<TreeNode> memory = new Stack<TreeNode>();
            getParents(root, p, memory);
            if (!memory.empty()) return memory.pop();
            return null;
        }
    }
}
