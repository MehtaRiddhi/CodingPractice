package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/26/16.
 */
public class M238_ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int L = nums.length;
        if (L == 0) return nums;
        int [] result = new int[L];
        result[0] = 1;
        for (int i = 1; i < L; i++) result[i] = result[i-1] * nums[i-1];
        for (int i = L - 2; i >= 0; i--){
            result[0] *= nums[i + 1];
            if (i > 0) result[i] *= result[0];
        }
        return result;
    }
}
