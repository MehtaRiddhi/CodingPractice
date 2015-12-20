package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 12/20/15.
 */

import java.util.*;

public class E107_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ArrayList<List<Integer>> levelOrder(ArrayList<TreeNode> nodes, ArrayList<List<Integer>> acc){
        ArrayList<Integer> buff = new ArrayList<Integer>();
        ArrayList<TreeNode> next_nodes = new ArrayList<TreeNode>();

        for (TreeNode n : nodes){
            buff.add(n.val);
            if (n.left != null) next_nodes.add(n.left);
            if (n.right != null) next_nodes.add(n.right);
        }
        acc.add(buff);

        if (!next_nodes.isEmpty()) return levelOrder(next_nodes, acc);
        else return acc;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> acc = new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);

        if (root == null) return acc;
        ArrayList<List<Integer>> acc1 = levelOrder(nodes, acc);
        int l = acc1.size();
        for (int i = 1; i <= l; i++){
            result.add(acc1.get(l - i));
        }

        return result;
    }
}
