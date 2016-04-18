package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/18/16.
 */
public class M298_BinaryTreeLongestConsecutiveSequence {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void DFShelper(TreeNode root, int prevVal, int acc, int[] seq){
        if (root == null) {
            seq[0] = Math.max(seq[0], acc);
        }else{
            if (prevVal + 1 ==  root.val){
                DFShelper(root.left, root.val, acc + 1, seq);
                DFShelper(root.right, root.val, acc + 1, seq);
            }else {
                seq[0] = Math.max(seq[0], acc);

                DFShelper(root.left, root.val, 1, seq);
                DFShelper(root.right, root.val, 1, seq);
            }
        }
    }

    public int longestConsecutive(TreeNode root) {
        int [] seq = new int[1];
        if (root == null) return seq[0];
        seq[0] = 1;
        DFShelper(root.left, root.val, 1, seq);
        DFShelper(root.right, root.val, 1, seq);

        return seq[0];
    }
}
