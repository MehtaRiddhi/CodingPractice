package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/15/16.
 */
public class M162_FindPeakElement {
    private int getElement(int [] nums, int L, int pos){
        if (pos >= 0 && pos <= L - 1) return nums[pos];
        if (pos < 0) return nums[0] - 1;
        if (pos >= L) return nums[L - 1] -1 ;
        return 0;
    }
    private int findPeakElement(int[] nums, int L, int from, int to){
        if (to - from <= 2){
            for (int i = from; i <= to; i++){
                if ((getElement(nums, L, i) > getElement(nums, L, i - 1)) &&
                (getElement(nums, L, i) > getElement(nums, L, i + 1))) return i;
            }

            return -1;
        }
        else{
            int midId = (from + to) / 2;
            if (getElement(nums, L, midId) < getElement(nums, L, midId + 1))
                return findPeakElement(nums, L, midId + 1, to);

            if (getElement(nums, L, midId - 1) > getElement(nums, L, midId))
                return findPeakElement(nums, L, from, midId);

            int pL = findPeakElement(nums, L, from, midId);
            if (pL >= 0) return pL;
            return findPeakElement(nums, L, midId + 1, to);
        }
    }
    public int findPeakElement(int[] nums) {
        int L = nums.length;
        if (L <= 1) return 0;
        return findPeakElement(nums, L, 0, L - 1);
    }
}
