package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/15/16.
 */
public class M35_SearchInsertPosition {
    private int searchHelper(int [] nums, int target, int from, int to){

        if (target < nums[from]) return from;
        if (target > nums[to]) return to + 1;

        if (to - from <= 2){
            for (int i = from; i <= to; i++){
                if (nums[i] == target) return i;
                if (nums[i] > target) return i;
            }
        }else {
            int midId = (from + to) / 2;
            if (target <= nums[midId]) return searchHelper(nums, target, from, midId);
            else return searchHelper(nums, target, midId + 1, to);
        }

        return from;
    }
    public int searchInsert(int[] nums, int target) {
        int L = nums.length;
        if (L == 0) return 0;
        return searchHelper(nums, target, 0, L - 1);
    }
}
