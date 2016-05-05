package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");


        ArrayList<Integer> digits = new ArrayList<Integer>();
        digits.add(1);
        digits.add(2);
        digits.add(3);

        M284_PeekingIterator iter = new M284_PeekingIterator(digits.iterator());

    }
}