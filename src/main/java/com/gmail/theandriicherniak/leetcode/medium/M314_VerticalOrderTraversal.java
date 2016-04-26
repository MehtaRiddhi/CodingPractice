package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/25/16.
 */

import apple.laf.JRSUIUtils;

import java.util.*;

public class M314_VerticalOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void DFS(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> buffer){
        if (root != null) {
            if (!buffer.containsKey(x)) buffer.put(x, new TreeMap<Integer, ArrayList<Integer>>());
            if (!buffer.get(x).containsKey(y)) buffer.get(x).put(y, new ArrayList<Integer>());
            buffer.get(x).get(y).add(root.val);

            DFS(root.left, x - 1, y + 1, buffer);
            DFS(root.right, x + 1, y + 1, buffer);
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> buffer =
                new TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>>();
        DFS(root, 0, 0, buffer);

        for (TreeMap<Integer, ArrayList<Integer>> v : buffer.values()){
            ArrayList<Integer> ll = new ArrayList<Integer>();
            for (ArrayList<Integer> vv : v.values()){
                for (int vvv : vv) ll.add(vvv);
            }
            result.add(ll);
        }

        return result;
    }
}
