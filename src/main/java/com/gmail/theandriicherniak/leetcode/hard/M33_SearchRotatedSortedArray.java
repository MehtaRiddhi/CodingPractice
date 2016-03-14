package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/14/16.
 */
public class M33_SearchRotatedSortedArray {
    private int searchHelper(int [] nums, int target, int from, int to){

        if (nums[from] < nums[to] && (target < nums[from] || target > nums[to])) return -1;
        if (to == from){
            if (nums[from] == target) return from;
            return -1;
        }
        if (to - from == 1) {
            if (nums[from] == target) return from;
            if (nums[from + 1] == target) return from + 1;
            return -1;
        }
        int midId = (from + to) / 2;
        int id1 = searchHelper(nums, target, from, midId);
        int id2 = searchHelper(nums, target, midId + 1, to);
        if (id1 > -1) return id1;
        if (id2 > -1) return id2;

        return -1;
    }
    public int search(int[] nums, int target) {
        int L = nums.length;
        if (L > 0) return searchHelper(nums, target, 0, L - 1);
        return -1;
    }
}