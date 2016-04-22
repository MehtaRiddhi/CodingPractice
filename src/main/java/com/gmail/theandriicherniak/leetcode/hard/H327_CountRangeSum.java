package com.gmail.theandriicherniak.leetcode.hard;

import java.util.Arrays;

/**
 * Created by andriicherniak on 4/21/16.
 */
public class H327_CountRangeSum {
    private int helper(long[] buffer, int from, int to, long lower, long upper){
        if (from == to) {
            if (buffer[from] >= lower && buffer[from] <= upper) return 1;
            else return 0;
        }else{
            int midL = (from + to) / 2;
            int result = helper(buffer, from, midL, lower, upper) + helper(buffer, midL + 1, to, lower, upper);

            int i, j, k;
            for (i = from, j=k=midL+1; i <= midL; i++){
                while (j <= to && (buffer[j] - buffer[i]) < lower) j++;
                while (k <= to && (buffer[k] - buffer[i]) <= upper) k++;
                result += k - j;
            }
            Arrays.sort(buffer, from, to + 1);
            return result;
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;
        int L = nums.length;
        if (L == 0) return result;

        long [] buffer = new long[L];
        buffer[0] = nums[0];

        for (int i = 1; i < L; i++){
            buffer[i] = buffer[i-1] + nums[i];
        }

        return helper(buffer, 0, L-1, lower, upper);
    }
}
