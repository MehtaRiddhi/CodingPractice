package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/17/16.
 */
public class M268_MissingNumber {
    public int missingNumber(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        int buffer = 0;
        for (int i = 1; i <= L; i ++) buffer ^= i;
        for (int i = 0; i < L; i++) buffer ^= nums[i];
        buffer ^= 0;
        return buffer;
    }
}
