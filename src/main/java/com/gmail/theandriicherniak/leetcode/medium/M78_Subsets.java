package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/24/16.
 */

import java.util.*;

public class M78_Subsets {

    private void subsetHelper(int[] nums, int numsL, int prefixL, int targetL, int startPos, boolean[] bitmap, List<List<Integer>> buffer){
        if (prefixL == targetL){
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int i = 0; i < numsL; i++) if (bitmap[i]) r.add(nums[i]);
            buffer.add(r);
        }
        if (prefixL < targetL){
            for (int i = startPos; i < numsL; i++){
                if (!bitmap[i] && (numsL - i >= targetL - prefixL)){
                    bitmap[i] = true;
                    subsetHelper(nums, numsL, prefixL + 1, targetL, i + 1, bitmap, buffer);
                    bitmap[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int L = nums.length;
        if (L == 0) return result;

        result.add(new ArrayList<Integer>());

        boolean[] bitmap = new boolean[L];

        for (int i = 1; i <= L; i++){
            for (int j = 0; j < L; j++) bitmap[j] = false;
            subsetHelper(nums, L, 0, i, 0, bitmap, result);
        }

        System.out.println(result);

        return result;
    }
}
