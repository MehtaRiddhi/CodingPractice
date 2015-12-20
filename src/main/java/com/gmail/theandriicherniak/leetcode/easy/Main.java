package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");
        E101_SymmetricTree test = new E101_SymmetricTree();
        E101_SymmetricTree.TreeNode t1 = test.new TreeNode(1);

        System.out.println(test.isSymmetric(t1));
    }
}
