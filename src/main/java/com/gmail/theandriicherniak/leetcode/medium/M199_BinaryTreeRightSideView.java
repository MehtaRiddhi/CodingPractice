package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/29/16.
 */

import java.util.*;

public class M199_BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        ArrayList<TreeNode> n_list = new ArrayList<TreeNode>();
        n_list.add(root);

        while (!n_list.isEmpty()) {
            int L = n_list.size();
            result.add(n_list.get(L - 1).val);

            ArrayList<TreeNode> n_list_new = new ArrayList<TreeNode>();

            for (TreeNode x : n_list) {
                if (x.left != null) n_list_new.add(x.left);
                if (x.right != null) n_list_new.add(x.right);
            }

            n_list = n_list_new;
        }

        return result;
    }
}
