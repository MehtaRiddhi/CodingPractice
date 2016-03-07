package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Random;

/**
 * Created by andriicherniak on 3/7/16.
 */
public class M215_KthLargestElementArray {
    Random rnd;
    private void swap(int [] nums, int id1, int id2){
        int tmp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = tmp;
    }
    private int pSelect(int [] nums, int from, int to, int pos){
        if (to - from == 0) return nums[from];
        if (to - from == 1){
            if (nums[from] > nums[from + 1]) swap(nums, from, from + 1);
            if (pos == from) return nums[from];
            if (pos == from + 1) return nums[from + 1];
        }
        int id = from + (int)Math.round(rnd.nextDouble() * (to - from));
        swap(nums, from, id);
        int leId = from;
        for (int j = from + 1; j <= to; j++){
            if (nums[j] <= nums[from]) swap(nums, j, ++leId);
        }
        swap(nums, from, leId);

        if (pos == leId) return nums[leId];
        if (pos > leId) return pSelect(nums, leId + 1, to, pos);
        else return pSelect(nums, from, leId - 1, pos);

    }
    public int findKthLargest(int[] nums, int k) {
        rnd = new Random(System.currentTimeMillis());
        int L = nums.length;
        return pSelect(nums, 0, L - 1, L - 1 - (k - 1));
    }
}
