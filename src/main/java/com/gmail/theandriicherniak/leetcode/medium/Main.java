package com.gmail.theandriicherniak.leetcode.medium;


import java.util.List;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M338_CountingBits cb = new M338_CountingBits();
        int [] bits = cb.countBits(5);
        for (int i = 0; i <= bits.length - 1; i++)System.out.print(bits[i] + ",");

    }
}