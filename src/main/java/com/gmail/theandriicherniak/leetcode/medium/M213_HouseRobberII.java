package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/1/16.
 */
public class M213_HouseRobberII {
    public int rob(int[] nums) {
        int L = nums.length;
        if (L <= 0) return 0;
        if (L == 1) return nums[0];
        if (L == 2) return Math.max(nums[0], nums[1]);

        int [] money = new int[L];

        money[0] = nums[0];
        for (int i = 1; i < L - 1; i++){
            if (i - 2 >= 0) money[i] = Math.max(nums[i] + money[i - 2], money[i-1]);
            else money[i] = Math.max(nums[i], money[i-1]);
        }

        int result = money[L-2];

        money[0] = 0;
        money[1] = nums[1];

        for (int i = 2; i < L; i++){
            money[i] = Math.max(nums[i] + money[i - 2], money[i-1]);
        }

        result = Math.max(result, money[L-1]);


        return result;
    }
}
