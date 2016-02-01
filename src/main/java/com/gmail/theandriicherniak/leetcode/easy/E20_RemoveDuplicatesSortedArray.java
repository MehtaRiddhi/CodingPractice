package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/31/16.
 */
public class E20_RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int L = nums.length;
        int i_deduped = 0;
        int tmp_val = 0;

        for (int i = 1; i < L; i++){
            tmp_val = nums[i];
            if (tmp_val != nums[i_deduped]) {
                i_deduped ++;
                nums[i_deduped] = tmp_val;
            }
        }

        return (i_deduped + 1);
    }
}
