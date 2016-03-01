package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/1/16.
 */
public class M53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return nums[0];


        int [] bestSum = new int[L];
        bestSum[0] = nums[0];
        int bestResult = nums[0];

        for (int i = 1; i < L; i++){
            bestSum[i] = Math.max(nums[i], bestSum[i-1] + nums[i]);
            bestResult = Math.max(bestResult, bestSum[i]);
        }

        return bestResult;
    }
}
