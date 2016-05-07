package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M324_WiggleSortII sort = new M324_WiggleSortII();
        int [] nums = new int[]{1, 3, 2, 2, 3, 1};
        sort.wiggleSort(nums);

        for (int v : nums) System.out.print(v + " ");

    }
}