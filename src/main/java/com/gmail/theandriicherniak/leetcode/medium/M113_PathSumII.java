package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/22/16.
 */
import java.util.*;

public class M113_PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> result, ArrayList<Integer> path, int prev_sum){
        int cur_sum = prev_sum + root.val;
        path.add(root.val);
        int L = path.size();

        if (root.left == null && root.right == null){
            if (cur_sum == sum){
                ArrayList<Integer> good_path = new ArrayList<Integer>(path);
                result.add(good_path);
            }
        }else{
            if (root.left != null) pathSumHelper(root.left, sum, result, path, cur_sum);
            while (path.size() > L) path.remove(path.size() - 1);
            if (root.right != null) pathSumHelper(root.right, sum, result, path, cur_sum);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        pathSumHelper(root, sum, result, new ArrayList<Integer>(), 0);
        return result;
    }
}
