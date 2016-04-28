package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class M80_RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int L = nums.length;
        if (L <= 2) return L;

        int v = nums[0];
        int v_cnt = 1;
        int newL = 1;

        for (int i = 1; i < L; i++){
            if (nums[i] > v){
                v = nums[i];
                v_cnt = 1;
                nums[newL] = nums[i];
                newL ++;
            }else {
                v_cnt ++;
                if (v_cnt <= 2) {
                    nums[newL] = nums[i];
                    newL ++;
                }
            }
        }

        return newL;
    }
}
