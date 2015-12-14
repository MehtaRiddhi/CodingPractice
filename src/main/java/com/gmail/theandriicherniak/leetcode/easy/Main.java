package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");
        SymmetricTree101 test = new SymmetricTree101();
        SymmetricTree101.TreeNode t1 = test.new TreeNode(1);

        System.out.println(test.isSymmetric(t1));
    }
}
