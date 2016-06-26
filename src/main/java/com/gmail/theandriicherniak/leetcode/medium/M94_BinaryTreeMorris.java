package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 6/16/16.
 */

import java.util.*;

public class M94_BinaryTreeMorris {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode current = root;
        TreeNode pred;
        while (current != null){
            if (current.left == null){
                result.add(current.val);
                current = current.right;
            }else {
                pred = current.left;
                while (pred.right != null && pred.right != current) pred = pred.right;

                if (pred.right == null) {
                    pred.right = current;
                    current = current.left;
                }else {
                    pred.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
