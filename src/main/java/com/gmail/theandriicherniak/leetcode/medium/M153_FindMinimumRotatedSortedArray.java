package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/14/16.
 */
public class M153_FindMinimumRotatedSortedArray {
    private int findMin(int [] nums, int from, int to){
        if (from == to) return nums[from];
        if (to - from <= 1){
            return Math.min(nums[from], nums[from + 1]);
        }else {
            int midId = (from + to ) / 2;
            if (nums[midId] < nums[to]) return findMin(nums, from, midId);
            else return findMin(nums, midId + 1, to);
        }
    }
    public int findMin(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;

        return findMin(nums, 0, L - 1);
    }
}
