package com.gmail.theandriicherniak.leetcode.hard;

import java.util.ArrayList;

/**
 * Created by andriicherniak on 4/28/16.
 */
public class H297_SerializeDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();

        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> l2;

        boolean toContinue = true;

        l1.add(root);

        while (toContinue) {
            toContinue = false;
            l2 = new ArrayList<TreeNode>();

            for (TreeNode n : l1){
                if (n == null) sb.append("null,");
                else {
                    sb.append(n.val + ",");
                    l2.add(n.left);
                    l2.add(n.right);
                    if (n.left != null) toContinue = true;
                    if (n.right != null) toContinue = true;
                }
            }

            l1 = l2;
        }

        String result = sb.toString();
        int L = result.length();

        return result.substring(0, L-1);
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        int L = nodeValues.length;
        if (L == 0 || nodeValues[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> l2;

        l1.add(root);

        int pos = 1;
        TreeNode left, right;

        l2 = new ArrayList<TreeNode>();

        while (pos < L) {
            int L1 = l1.size();

            for (int i = 0; i < L1; i++) {
                TreeNode n = l1.get(i);

                if (n != null) {
                    if (pos < L) {
                        left = nodeValues[pos].equals("null") ? null : new TreeNode(Integer.parseInt(nodeValues[pos]));
                        pos++;
                    }else left = null;

                    if (pos < L) {
                        right = nodeValues[pos].equals("null") ? null : new TreeNode(Integer.parseInt(nodeValues[pos]));
                        pos++;
                    }else right = null;

                    n.left = left;
                    n.right = right;

                    System.out.print("node " + n.val + " ");
                    if (n.left == null) System.out.print("null ");
                    else System.out.print(n.left.val + " ");
                    if (n.right == null) System.out.println("null");
                    else System.out.println(n.right.val);

                    l2.add(left);
                    l2.add(right);
                }
            }

//            System.out.println("new level");

            l1 = l2;
        }

        return root;
    }
}
