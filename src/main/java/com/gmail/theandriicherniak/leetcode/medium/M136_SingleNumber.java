package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/17/16.
 */
public class M136_SingleNumber {
    public int singleNumber(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return nums[0];
        int buffer = nums[0];
        for (int i = 1; i < L; i++) buffer ^= nums[i];
        buffer ^= 0;
        return buffer;
    }
}
