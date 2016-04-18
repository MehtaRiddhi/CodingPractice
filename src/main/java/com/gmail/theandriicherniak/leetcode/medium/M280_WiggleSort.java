package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Arrays;

/**
 * Created by andriicherniak on 4/18/16.
 */
public class M280_WiggleSort {
    private void swap(int i1, int i2, int [] nums){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int L = nums.length;
        if (L >= 3){
            int i1 = 1;
            int i2 = 2;
            while (i2 <= L-1){
                swap(i1, i2, nums);
                i1 += 2;
                i2 += 2;
            }
        }
    }
}
