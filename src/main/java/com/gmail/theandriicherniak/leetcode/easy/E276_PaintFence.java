package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/14/16.
 */
public class E276_PaintFence {
    public int numWays(int n, int k) {
        if (k == 0) return 0;
        if (n == 0) return 0;

        if (n == 1) return k;
        if (n == 2) return k*k;

        int[] buffer = new int[n];
        buffer[0] = k;
        buffer[1] = k*k;
        for (int i = 2; i < n; i++){
            buffer[i] = (buffer[i-2] + buffer[i-1])* (k - 1);
        }
        return buffer[n-1];
    }
}
