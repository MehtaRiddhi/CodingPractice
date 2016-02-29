package com.gmail.theandriicherniak.leetcode.medium;

import java.util.*;

/**
 * Created by andriicherniak on 2/29/16.
 */
public class M31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int L = nums.length;
        if (L <= 1) return;
        boolean permuted = false;
        HashMap<Integer, Integer> visitedDigits = new HashMap<Integer, Integer>();
        int pos = L - 1;
        int digit, digit_compare;

        while (pos >= 0 && !permuted) {
            digit = nums[pos];
            visitedDigits.put(digit, pos);

            digit_compare = Integer.MAX_VALUE;

            for (int v : visitedDigits.keySet()) {
                if (v > digit) digit_compare = Math.min(digit_compare, v);
            }

            if (visitedDigits.containsKey(digit_compare)) {
                permuted = true;
                int tmp_pos = visitedDigits.get(digit_compare);
                int tmp = nums[tmp_pos];
                nums[tmp_pos] = nums[pos];
                nums[pos] = tmp;
                Arrays.sort(nums, pos + 1, L);
            }

            digit_compare++;

            pos--;
        }

        if (!permuted) Arrays.sort(nums);

        for (int i = 0; i < L; i++) {
            System.out.print(nums[i]+",");
        }
    }
}
