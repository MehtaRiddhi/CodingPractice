package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");
        M261_GraphValidTree t = new M261_GraphValidTree();
        t.validTree(5, new int[][]{new int[]{0,1},new int[]{0,2},new int[] {2,3},new int[] {2,4}});
    }
}
