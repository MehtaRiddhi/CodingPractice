package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M309_BestTimeBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        int L = prices.length;
        if (L <= 1) return 0;
        int [] s = new int[L];
        int [] c = new int[L];
        s[1] = prices[1] - prices[0];

        for (int i = 2; i < L; i++){
            c[i] = Math.max(c[i-1], s[i-1]);
            s[i] = prices[i] - prices[i-1] + Math.max(c[i-2], s[i-1]);
        }
        return Math.max(s[L-1], c[L-1]);
    }
}