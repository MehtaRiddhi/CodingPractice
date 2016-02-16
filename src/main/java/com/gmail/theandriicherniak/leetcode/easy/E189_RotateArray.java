package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/15/16.
 */
public class E189_RotateArray {
    private void reverse(int[] nums, int l, int r) {
        int tmp;

        while (l < r){

            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;

        }
    }

    public void rotate(int[] nums, int k) {
        int L = nums.length;
        k = k % L;

        if (k > 0) {

            reverse(nums, 0, L - k - 1);
            reverse(nums, L - k, L - 1);
            reverse(nums, 0, L - 1);
        }
    }
}
