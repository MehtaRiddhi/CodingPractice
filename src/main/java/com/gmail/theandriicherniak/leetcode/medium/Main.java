package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M75_SortColors sc = new M75_SortColors();
        int [] nums = new int[]{0,0};
        sc.sortColors(nums);
        for (int i = 0; i < nums.length; i++) System.out.println(nums[i]);
    }
}