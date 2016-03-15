package com.gmail.theandriicherniak.leetcode.medium;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by andriicherniak on 3/15/16.
 */
public class M230_KthSmallestElementBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void extractLeftSubtree(TreeNode x, Stack<TreeNode> s){
        while (x != null) {
            s.push(x);
            x = x.left;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        extractLeftSubtree(root, s);

        int cnt = 0;

        while (!s.empty()){
            TreeNode x = s.pop();
            cnt ++;
            if (cnt == k) return x.val;
            extractLeftSubtree(x.right, s);
        }

        return 0;
    }
}
