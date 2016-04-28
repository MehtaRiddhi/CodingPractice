package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class M334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int L = nums.length;
        if (L < 3) return false;
        int max3 = nums[L-1];
        int max2 = Integer.MIN_VALUE;
        for (int i = L - 2; i >= 1; i --){
            if (nums[i] < max3) max2 = Math.max(max2, nums[i]);
            max3 = Math.max(max3, nums[i]);
            if (nums[i - 1] < max2) return true;
        }
        return false;
    }
}
