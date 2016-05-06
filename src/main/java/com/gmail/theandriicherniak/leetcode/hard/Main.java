package com.gmail.theandriicherniak.leetcode.hard;

public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running hard examples");

        H297_SerializeDeserializeBinaryTree tree = new H297_SerializeDeserializeBinaryTree();

//        H297_SerializeDeserializeBinaryTree.TreeNode n1 = tree.new TreeNode(1);
//        H297_SerializeDeserializeBinaryTree.TreeNode n2 = tree.new TreeNode(2);
//        H297_SerializeDeserializeBinaryTree.TreeNode n3 = tree.new TreeNode(3);
//        H297_SerializeDeserializeBinaryTree.TreeNode n4 = tree.new TreeNode(4);
//        H297_SerializeDeserializeBinaryTree.TreeNode n5 = tree.new TreeNode(5);
//
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;
//
//        String s1 = tree.serialize(n1);
//        String s2 = tree.serialize(tree.deserialize(s1));
//
//        System.out.println(s1);
//        System.out.println(s2);

        String s1 = "1,null,3";
        System.out.println(tree.serialize(tree.deserialize(s1)));

    }
}
