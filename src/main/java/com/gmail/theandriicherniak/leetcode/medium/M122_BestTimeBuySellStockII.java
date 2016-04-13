package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/12/16.
 */
public class M122_BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int L = prices.length;
        if (L == 0) return 0;
        int profit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < L; i++){
            if (prices[i] < prices[i-1]) {
                profit += Math.max(0, prices[i-1] - buyPrice);
                buyPrice = prices[i];
            }
            buyPrice = Math.min(buyPrice, prices[i]);
        }

        profit += Math.max(0, prices[L-1] - buyPrice);

        return profit;
    }
}
