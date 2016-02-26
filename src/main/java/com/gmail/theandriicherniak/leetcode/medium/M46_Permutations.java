package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/25/16.
 */

import java.util.*;

public class M46_Permutations {
    private void permutationDFS(int nums[], int pos, int L, List<List<Integer>> result) {
        if (pos == L) {
            ArrayList<Integer> rr = new ArrayList<Integer>();
            for (int i = 0; i < L; i++) rr.add(nums[i]);
            result.add(rr);
        }
        if (pos < L) {
            int tmp;
            for (int i = pos; i < L; i++) {
                tmp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = tmp;

                permutationDFS(nums, pos + 1, L, result);

                nums[i] = nums[pos];
                nums[pos] = tmp;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int L = nums.length;
        permutationDFS(nums, 0, L, result);
        return result;
    }
}
