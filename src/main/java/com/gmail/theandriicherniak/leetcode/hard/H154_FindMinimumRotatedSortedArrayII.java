package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/14/16.
 */
public class H154_FindMinimumRotatedSortedArrayII {
    private int findMin(int [] nums, int from, int to){
        if (from == to) return nums[from];
        if (to - from <= 1){
            return Math.min(nums[from], nums[from + 1]);
        }else {
            int midId = (from + to ) / 2;
            int minL = Math.min(nums[from], nums[midId]);
            int minR = Math.min(nums[midId + 1], nums[to]);
            if (minL < minR) return findMin(nums, from, midId);
            if (minR < minL) return findMin(nums, midId + 1, to);
            return Math.min(findMin(nums, from, midId), findMin(nums, midId + 1, to));
        }
    }
    public int findMin(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;

        return findMin(nums, 0, L - 1);
    }
}
