package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/18/16.
 */
public class M75_SortColors {
    private void swap(int i1, int i2, int[] nums){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public void sortColors(int[] nums) {
        int L = nums.length;
        if (L <= 1) return;

        int ptr0 = 0;
        int ptr2 = L - 1;
        int i = 0;
        boolean swapped = false;

        while (i <= ptr2){
            swapped = false;
            if (nums[i] == 0 && i > ptr0) {
                swap(ptr0, i, nums);
                ptr0 ++;
                swapped = true;
            }
            else if (nums[i] == 2 && i < ptr2) {
                swap(ptr2, i, nums);
                ptr2 --;
                swapped = true;
            }
            if (! swapped) i ++;
        }
    }
}
