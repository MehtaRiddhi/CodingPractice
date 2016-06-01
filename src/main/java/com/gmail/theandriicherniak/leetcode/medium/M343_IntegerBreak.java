package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 6/1/16.
 */
public class M343_IntegerBreak {
    public int integerBreak(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        int [] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++){
            for (int v = 1; v <= i/2; v++){
                int p1 = Math.max(v, dp[v]);
                int p2 = Math.max(i-v, dp[i-v]);

                dp[i] = Math.max(dp[i], p1 * p2);
            }
        }

        return dp[n];
    }
}
