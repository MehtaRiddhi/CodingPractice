package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/17/16.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class E94_BinaryTreeInorderTraversal {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode n = root;

        while (n != null){
            s.add(n);
            n = n.left;
        }
        while (!s.empty()){
            n = s.pop();
            result.add(n.val);

            if (n.right != null) {
                n = n.right;

                while (n != null) {
                    s.add(n);
                    n = n.left;
                }
            }
        }
        return result;
    }
}
