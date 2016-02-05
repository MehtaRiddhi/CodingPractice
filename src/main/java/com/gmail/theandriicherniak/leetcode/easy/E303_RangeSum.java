package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/4/16.
 */
public class E303_RangeSum {
    int [] partial_sum;
    int [] num_array;
    public E303_RangeSum(int[] nums) {
        num_array = nums;
        int l = nums.length;
        partial_sum = new int[l];
        int sum = 0;
        for (int i = (l-1); i >= 0; i--){
            sum += nums[i];
            partial_sum[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return partial_sum[i] - partial_sum[j] + num_array[j];
    }
}
