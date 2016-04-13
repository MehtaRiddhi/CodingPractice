package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M279_PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int k;

        int[] buffer = new int[n + 1];
        int vv;
        int minL;

        buffer[1] = 1;

        for (int v = 2; v <= n; v++) {
            k = (int) Math.floor(Math.sqrt(v));
            if (v == k * k) {
                buffer[v] = 1;
                continue;
            }
            for (int i = 1; i <= k; i++) {
                vv = v - i * i;
                minL = 1 + buffer[vv];
                if (buffer[v] == 0) buffer[v] = minL;
                else buffer[v] = Math.min(buffer[v], minL);
            }
        }

        return buffer[n];
    }
}
