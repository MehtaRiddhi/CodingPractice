package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 12/13/15.
 */
public class InvertBinaryTree226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode invertTreeHelper(TreeNode root){
        if (root == null) return root;
        TreeNode l = root.right;
        TreeNode r = root.left;
        root.left = invertTreeHelper(l);
        root.right = invertTreeHelper(r);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        return invertTreeHelper(root);
    }
}
