package com.gmail.theandriicherniak.leetcode.medium;


/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M221_MaximalSquare s = new M221_MaximalSquare();
        System.out.println(s.maximalSquare(new char[][]{
                "1010".toCharArray(),
                "1011".toCharArray(),
                "1011".toCharArray(),
                "1111".toCharArray()}));

    }
}