package com.gmail.theandriicherniak.leetcode.medium;


/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        M300_LongestIncreasingSubsequence lis = new M300_LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int [] {10, 9, 2, 5, 3, 7, 101, 18}));
    }
}