package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/14/16.
 */
public class M34_SearchRange {
    private int [] searchHelper(int [] nums, int target, int from, int to){
        if (nums[from] > target || nums[to] < target) return new int[]{-1, -1};

        if (to - from <= 1) {
            int [] result = new int[]{-1, -1};
            for (int i = from; i <= to; i++){
                if (nums[i] == target && result[0] == -1) result[0] = i;
                if (nums[i] == target) result[1] = Math.max(i, result[1]);
            }

            return result;
        }
        int midId = (from + to) / 2;

        if ((target <= nums[midId]) && (target < nums[midId + 1])) return searchHelper(nums, target, from, midId);
        if ((target > nums[midId]) && (target >= nums[midId + 1])) return searchHelper(nums, target, midId + 1, to);
        int [] LR = searchHelper(nums, target, from, midId);
        int [] RR = searchHelper(nums, target, midId + 1, to);
        int [] result = new int[]{LR[0], RR[1]};
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[]{-1, -1};
        int L = nums.length;

        if (L > 0 && nums[0] <= target && nums[L - 1] >= target){
            result = searchHelper(nums, target, 0, L - 1);
        }

        return result;
    }
}
