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

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> nodes = new ArrayList<String>();

        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> l2;
        l1.add(root);

        while (!l1.isEmpty()) {
            l2 = new ArrayList<TreeNode>();

            for (TreeNode n : l1) {
                if (n != null) {
                    nodes.add("" + n.val);
                    l2.add(n.left);
                    l2.add(n.right);
                } else nodes.add("null");
            }

            l1 = l2;
        }

        int L = nodes.size();
        int i = L - 1;
        while (i >= 0 && nodes.get(i).equals("null")) i--;
        if (i >= 0) {
            sb.append(nodes.get(0));
            for (int j = 1; j <= i; j++) {
                sb.append("," + nodes.get(j));
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] ar = data.split(",");

        int L = ar.length;
        if (L == 0) return null;

        if (ar[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(ar[0]));
        ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> l2;

        l1.add(root);
        int pos = 1;
        int nonNullL = 1;

        while (pos < L) {
            l2 = new ArrayList<TreeNode>();
            for (int i = 1; i <= 2 * nonNullL; i++) {
                if (pos < L){
                    String v = ar[pos];
                    if (v.equals("null")) l2.add(null);
                    else l2.add(new TreeNode(Integer.parseInt(v)));

                    pos ++;
                }else l2.add(null);
            }
            int cnt = 0;
            int j = 0;
            for (int i = 0; i < l1.size(); i++){
                TreeNode n = l1.get(i);
                if (n != null){
                    n.left = l2.get(j);
                    n.right = l2.get(j + 1);
                    j += 2;
                }
            }
            for (int i = 0; i < l2.size(); i++){
                if (l2.get(i) != null) cnt ++;
            }

            l1 = l2;

            nonNullL = cnt;
        }

        return root;
    }
}
