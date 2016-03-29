package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/29/16.
 */
public class M108_ConvertSortedArrayBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode BSThelper(int[] nums, int from, int to){
        if (from > to) return null;
        int midPoint = (from + to) / 2;

        TreeNode x = new TreeNode(nums[midPoint]);
        x.left = BSThelper(nums, from, midPoint - 1);
        x.right = BSThelper(nums, midPoint + 1, to);
        return x;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int L = nums.length;
        if (L == 0) return null;
        if (L >= 1) {
            return BSThelper(nums, 0, L - 1);
        }

        return null;
    }
}
