package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/17/16.
 */

import java.util.List;
import java.util.ArrayList;

public class E257_BinaryTreePaths {
    ArrayList<String> paths = new ArrayList<String>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void DFS_helper(TreeNode root, String prefix){
        if (root != null) {
            String new_prefix;
            if (prefix.equals("")) new_prefix = prefix + root.val;
            else new_prefix = prefix + "->" + root.val;

            if (root.left != null) DFS_helper(root.left, new_prefix);
            if (root.right != null) DFS_helper(root.right, new_prefix);
            if (root.left == null && root.right == null) paths.add(new_prefix);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return paths;
        DFS_helper(root, "");
        return paths;
    }
}
