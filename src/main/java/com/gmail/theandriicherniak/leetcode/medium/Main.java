package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        M153_FindMinimumRotatedSortedArray m = new M153_FindMinimumRotatedSortedArray();
        System.out.println(m.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}