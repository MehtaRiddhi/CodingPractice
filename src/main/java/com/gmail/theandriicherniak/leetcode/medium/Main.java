package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        M34_SearchRange sr = new M34_SearchRange();
        int [] range = sr.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(range[0] + " " + range[1]);
    }
}