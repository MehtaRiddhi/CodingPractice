package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/22/16.
 */
import java.util.*;

public class H239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int L = nums.length;
        if (L < k || k <= 0) return new int[0];
        int [] result = new int [L-k+1];

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());

        for (int i = 0; i < k; i++) q.add(nums[i]);
        result[0] = q.peek();

        for (int i = k; i < L; i++) {
            q.add(nums[i]);
            q.remove(nums[i-k]);

            result[i-k+1] = q.peek();
        }

        return result;
    }
}
