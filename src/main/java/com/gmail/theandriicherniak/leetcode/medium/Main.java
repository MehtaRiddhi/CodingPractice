package com.gmail.theandriicherniak.leetcode.medium;


import java.util.List;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M15_3Sum s = new M15_3Sum();
        int [] data = new int [] {-2, 0,0,2,2};

        List<List<Integer>> result = s.threeSum(data);

        for (List<Integer> r : result){
            System.out.println(r);
        }

    }
}