package com.gmail.theandriicherniak.leetcode.medium;


/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        M209_MinimumSizeSubarraySum ms = new M209_MinimumSizeSubarraySum();
        System.out.println(ms.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}