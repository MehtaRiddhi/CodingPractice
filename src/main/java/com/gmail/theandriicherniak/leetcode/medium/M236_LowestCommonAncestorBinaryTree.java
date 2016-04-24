package com.gmail.theandriicherniak.leetcode.medium;

import java.util.*;

/**
 * Created by andriicherniak on 4/23/16.
 */
public class M236_LowestCommonAncestorBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int DFShelper(TreeNode root, TreeNode t, ArrayList<TreeNode> path) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> level = new Stack<Integer>();

        stack.add(root);
        level.add(1);

        TreeNode next;
        int curLevel;

        while (!stack.empty()){
            next = stack.pop();
            curLevel = level.pop();
            if (curLevel > path.size()) path.add(next);
            else path.set(curLevel - 1, next);

            if (next == t) return curLevel;
            if (next.right != null) {
                stack.add(next.right);
                level.add(curLevel + 1);
            }
            if (next.left != null) {
                stack.add(next.left);
                level.add(curLevel + 1);
            }
        }

        return 0;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        ArrayList<TreeNode> path_p = new ArrayList<TreeNode>();
        ArrayList<TreeNode> path_q = new ArrayList<TreeNode>();

        TreeNode ancestor = root;


        int Lp = DFShelper(root, p, path_p);
        int Lq = DFShelper(root, q, path_q);

        for (int i = 0; i < Math.min(Lp, Lq); i++){
            if (path_p.get(i) == path_q.get(i)) ancestor = path_p.get(i);
        }


        return ancestor;
    }
}
