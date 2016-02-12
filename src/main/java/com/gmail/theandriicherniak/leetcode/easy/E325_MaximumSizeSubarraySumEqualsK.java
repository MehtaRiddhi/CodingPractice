package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/11/16.
 */
import java.util.HashMap;
public class E325_MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) return 0;
        HashMap<Integer, Integer> partial_sum = new HashMap<Integer, Integer>();

        int L = nums.length;
        int sum = 0;
        int complementary_sum = 0;
        int k_len = 0;

        for (int i = 0; i < L; i++){
            sum += nums[i];

            if (!partial_sum.containsKey(sum)) partial_sum.put(sum, i);
            if (sum == k) k_len = i + 1;

            complementary_sum = sum - k;

            if (partial_sum.containsKey(complementary_sum)){
                int d = i - partial_sum.get(complementary_sum);

                k_len = Math.max(k_len, d);
            }
        }

        return k_len;
    }
}
