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

        int id1 = 0;
        int id2, id3;
        while (id1 < L -2){
            int v1 = nums[id1];
            id2 = id1 + 1;
            id3 = L - 1;
            while (id2 < id3){
                if (v1 + nums[id2] + nums[id3] >= target) id3 --;
                else if (v1 + nums[id2] + nums[id3] < target){
                    counter += id3 - id2;
                    id2 ++;
                }
            }
            id1 ++;
        }

        return counter;
    }
}
