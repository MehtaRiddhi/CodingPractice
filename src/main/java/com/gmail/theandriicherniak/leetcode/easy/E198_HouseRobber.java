package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/14/16.
 */
import java.util.HashMap;
public class E198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return nums[0];
        int option1, option2, best_option;

        HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();
        buffer.put(0, nums[0]);
        for (int pos = 1; pos < L; pos ++){
            option1 = buffer.get(pos - 1);
            option2 = nums[pos];
            if (buffer.containsKey(pos - 2)) option2 += buffer.get(pos - 2);
            best_option = Math.max(option1, option2);
            buffer.put(pos, best_option);
        }

        return buffer.get(L - 1);
    }
}
