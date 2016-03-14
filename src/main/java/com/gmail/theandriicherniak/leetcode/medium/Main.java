package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        M50_Pow p = new M50_Pow();
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " " + p.myPow(2, i));
        }
    }
}