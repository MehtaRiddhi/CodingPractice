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
        int j;
        int upperLimit1 = L-1;
        int upperLimit2;

        while (i < L - 2 && (nums[i] + nums[i+1] + nums[i+2] < target)){
            while (nums[i] + nums[i+1] + nums[upperLimit1] >= target && upperLimit1 >= i + 2) upperLimit1 --;
            j = i + 1;
            while (j < L - 1 && (nums[i] + nums[j] + nums[j+1] < target)){
                upperLimit2 = upperLimit1;
                while (nums[i] + nums[j] + nums[upperLimit2] >= target && upperLimit2 >= j + 1) upperLimit2 --;
                counter += upperLimit2 - j;
                j++;
            }
            i++;
        }
        return counter;
    }
}
