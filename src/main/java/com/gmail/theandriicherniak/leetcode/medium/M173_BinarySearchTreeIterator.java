package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Stack;

/**
 * Created by andriicherniak on 3/29/16.
 */
public class M173_BinarySearchTreeIterator {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }

    Stack<TreeNode> memory;

    public M173_BinarySearchTreeIterator(TreeNode root) {
        memory = new Stack<TreeNode>();
        populateStack(root);
    }

    private void populateStack(TreeNode x){
        while (x != null){
            memory.push(x);
            x = x.left;
        }
    }

    public boolean hasNext() {
        return !memory.empty();
    }

    public int next() {
        TreeNode x = memory.pop();
        populateStack(x.right);
        return x.val;
    }
}
