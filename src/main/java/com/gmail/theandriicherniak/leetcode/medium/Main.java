package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M94_BinaryTreeInorderTraversal_Morris tree = new M94_BinaryTreeInorderTraversal_Morris();
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n1 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(1);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n2 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(2);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n3 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(3);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n4 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(4);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n5 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(5);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n6 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(6);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n7 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(7);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n8 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(8);
        M94_BinaryTreeInorderTraversal_Morris.TreeNode n9 =  new M94_BinaryTreeInorderTraversal_Morris.TreeNode(9);


        n5.left = n3;
        n5.right = n8;

        n3.left = n2;
        n3.right = n4;

        n2.left = n1;

        n8.left = n6;
        n8.right = n9;
        n6.right = n7;

        System.out.println(tree.inorderTraversal(n5));


    }
}