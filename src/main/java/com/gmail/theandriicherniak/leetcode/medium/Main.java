package com.gmail.theandriicherniak.leetcode.medium;


import java.util.*;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");


        M120_Triangle t = new M120_Triangle();
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        ArrayList<Integer> v1 = new ArrayList<Integer>();
        ArrayList<Integer> v2 = new ArrayList<Integer>();
        ArrayList<Integer> v3 = new ArrayList<Integer>();


        v1.add(-1);

        v2.add(3);
        v2.add(2);

        v3.add(-3);
        v3.add(1);
        v3.add(-1);

        data.add(v1);
        data.add(v2);
        data.add(v3);

        t.minimumTotal(data);
    }
}