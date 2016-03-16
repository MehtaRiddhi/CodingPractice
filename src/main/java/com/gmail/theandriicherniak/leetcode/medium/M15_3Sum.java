package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/16/16.
 */
import java.util.*;

public class M15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int L = nums.length;
        if (L < 3) return result;

        Arrays.sort(nums);

        if (nums[0] > 0) return result;
        if (nums[L - 1] < 0) return result;

        int i = 0;
        int v1 = nums[i];
        while (i < L - 2 && v1 <= 0){
            int start = i + 1;
            int end = L - 1;

            while (start < end){
                int v2 = nums[start];
                int v3 = nums[end];
                int v = v1 + v2 + v3;
                if (v > 0) end --;
                if (v < 0) start ++;
                if (v == 0){
                    ArrayList<Integer> tuple = new ArrayList<Integer>();
                    tuple.add(v1);
                    tuple.add(nums[start]);
                    tuple.add(nums[end]);
                    result.add(tuple);
                    while (start < end && nums[start] == v2) start ++;
                    while (start < end && nums[end] == v3) end --;

                }
            }

            while (i < L - 1 && nums[i] == v1) {
                i++;
            }
            v1 = nums[i];
        }

        return result;
    }
}
