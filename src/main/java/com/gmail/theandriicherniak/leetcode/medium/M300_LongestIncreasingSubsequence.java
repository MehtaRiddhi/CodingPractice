package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/15/16.
 */
import java.util.*;

public class M300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return 1;
        HashMap<Integer, Integer> subsequence_set = new HashMap<Integer, Integer>();
        int maxL = 0;

        for (int i = L - 1; i >= 0; i--){
            int v = nums[i];
            int vL = 1;
            for (int vv : subsequence_set.keySet()){
                if (vv > v) vL = Math.max(vL, subsequence_set.get(vv) + 1);
            }
//            System.out.println(" v " + v + " vL " + vL);

            subsequence_set.put(v, vL);
            maxL = Math.max(maxL, vL);
        }
        return maxL;
    }
}
