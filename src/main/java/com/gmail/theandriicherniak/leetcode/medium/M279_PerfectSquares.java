package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M279_PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int k = (int) Math.floor(Math.sqrt(n));
        int [] numbers = new int[k];
        for (int i = 1; i <= k; i++) numbers[i-1] = i * i;

        int [] buffer = new int[n + 1];
        int vv;
        int minL;

        for (int i = 0; i < k; i++) buffer[numbers[i]] = 1;

        for (int v = 2; v <= n; v++){
            for (int i = 0; i < k; i++){
                vv = v - numbers[i];
                if (vv >= 1){
                    minL = 1 + buffer[vv];
                    if (buffer[v] == 0) buffer[v] = minL;
                    else buffer[v] = Math.min(buffer[v], minL);
                }
            }
        }

        return buffer[n];
    }
}
