package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Arrays;

/**
 * Created by andriicherniak on 4/18/16.
 */
public class M259_3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int L = nums.length;
        if (L < 3) return 0;

        Arrays.sort(nums);
        int counter = 0;
        int i = 0;
        int j, k;
        while (i < L - 2 && (nums[i] <= 0 || nums[i] < target)){
            j = i + 1;
            while (j < L - 1 && (nums[j] <= 0 || nums[i] + nums[j] < target)){

                k = j + 1;
                while (k < L && nums[i] + nums[j] + nums[k] < target){
                    counter ++;
                    k++;
                }
                j++;
            }
            i++;
        }
        return counter;
    }
}
