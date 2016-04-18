package com.gmail.theandriicherniak.leetcode.medium;

import com.gmail.theandriicherniak.leetcode.medium.M298_BinaryTreeLongestConsecutiveSequence.TreeNode;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M298_BinaryTreeLongestConsecutiveSequence t = new M298_BinaryTreeLongestConsecutiveSequence();
        TreeNode t1 = t.new TreeNode(1);
        TreeNode t2 = t.new TreeNode(2);
        TreeNode t3 = t.new TreeNode(3);
        TreeNode t4 = t.new TreeNode(4);
        TreeNode t5 = t.new TreeNode(5);

        t1.right = t3;
        t3.left = t2;
        t3.right = t4;
        t4.right = t5;

        System.out.println(t.longestConsecutive(t1));
    }
}