package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M163_MissingRanges mr = new M163_MissingRanges();
        for (String ss : mr.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99))
            System.out.println(ss);
    }
}