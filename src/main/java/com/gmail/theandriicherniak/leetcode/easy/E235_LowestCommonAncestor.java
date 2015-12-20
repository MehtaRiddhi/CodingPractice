package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 12/14/15.
 */

public class E235_LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val > p.val && root.val < q.val){
            return root;
        }else if(root.val > q.val && root.val < p.val){
            return root;
        }
        else if(root.val>p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val<p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
