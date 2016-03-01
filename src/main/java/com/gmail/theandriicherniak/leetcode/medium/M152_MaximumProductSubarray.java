package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/1/16.
 */
public class M152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return nums[0];

        int [] bestProductPositive = new int[L];
        int [] bestProductNegative = new int[L];

        bestProductPositive[0] = 1;
        bestProductNegative[0] = 1;


        if (nums[0] > 0) bestProductPositive[0] = nums[0];
        if (nums[0] < 0) bestProductNegative[0] = nums[0];

        int result = nums[0];


        for (int i = 1; i < L; i++){
            int v1 = nums[i] * bestProductPositive[i-1];
            int v2 = nums[i] * bestProductNegative[i-1];

            bestProductPositive[i] = Math.max(v2, Math.max(nums[i], v1));
            bestProductNegative[i] = Math.min(v2, Math.min(nums[i], v1));

            result = Math.max(result, bestProductPositive[i]);

            if (bestProductPositive[i] <= 0) bestProductPositive[i] = 1;
            if (bestProductNegative[i] >= 0) bestProductNegative[i] = 1;

        }


        return result;
    }
}
