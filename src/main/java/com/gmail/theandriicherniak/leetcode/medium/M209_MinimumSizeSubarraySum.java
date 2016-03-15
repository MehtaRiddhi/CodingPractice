package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/15/16.
 */
public class M209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        int minL = L;
        int sum = 0;
        int start = -1;
        boolean found = false;

        for (int i = 0; i < L; i++){
            sum += nums[i];
            while (sum >= s){
                found = true;
                minL = Math.min(minL, (i - start));
                start ++;
                sum -= nums[start];
            }
        }

        if (found) return minL;

        return 0;
    }
}
