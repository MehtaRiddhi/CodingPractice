package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/22/16.
 */
import java.util.*;

public class M129_SumRootLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void sumNumbersHelper(TreeNode root, int path_sum, ArrayList<Integer> buffer){
        int sum = path_sum * 10 + root.val;

        if (root.left == null && root.right == null){
            buffer.add(sum);
        }
        if (root.left != null) sumNumbersHelper(root.left, sum, buffer);
        if (root.right != null) sumNumbersHelper(root.right, sum, buffer);
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        int sum = 0;
        if (root == null) return sum;

        sumNumbersHelper(root, 0, buffer);

        for (int v : buffer) sum += v;
        return sum;
    }
}
