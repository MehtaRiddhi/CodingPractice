package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/15/16.
 */
public class M300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return 1;
        int [] subsequence_len = new int[L];
        int maxL = 0;

        for (int i = 0; i < L; i++){
            int bestL = 1;

            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    bestL = Math.max(bestL, subsequence_len[j] + 1);
                }
            }

            subsequence_len[i] = bestL;
            maxL = Math.max(maxL, bestL);
        }
        return maxL;
    }
}
