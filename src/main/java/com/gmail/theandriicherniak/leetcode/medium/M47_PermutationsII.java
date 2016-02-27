package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/26/16.
 */

import java.util.*;

public class M47_PermutationsII {
    private void permutationDFS(int nums[], int pos, int L, HashSet<List<Integer>> result) {
        if (pos == L) {
            ArrayList<Integer> rr = new ArrayList<Integer>();
            for (int i = 0; i < L; i++) rr.add(nums[i]);
            result.add(rr);
        }
        if (pos < L) {
            int tmp;

            HashSet<Integer> appeared = new HashSet<Integer>();

            for (int i = pos; i < L; i++) {
                if (!appeared.contains(nums[i])) {
                    appeared.add(nums[i]);

                    tmp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = tmp;

                    permutationDFS(nums, pos + 1, L, result);

                    nums[i] = nums[pos];
                    nums[pos] = tmp;
                }
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> buffer = new HashSet<List<Integer>>();

        int L = nums.length;
        permutationDFS(nums, 0, L, buffer);
        
        for(List<Integer> r :  buffer) result.add(r);

        return result;
    }
}
