package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/6/16.
 */
public class M121_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int L = prices.length;
        if (L == 0) return 0;

        int profit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < L; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }

        return profit;
    }
}
