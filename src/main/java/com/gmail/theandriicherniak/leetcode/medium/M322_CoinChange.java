package com.gmail.theandriicherniak.leetcode.medium;

import java.util.*;

/**
 * Created by andriicherniak on 4/7/16.
 */
public class M322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int L = coins.length;
        if (L == 0) return -1;

        int newL = 0;

        for (int i = 0; i < L; i++){
            if (coins[i] <= amount) newL ++;
        }

        if (newL == 0) return -1;
        int [] new_coins = new int[newL];
        newL = 0;

        for (int i = 0; i < L; i++){
            if (coins[i] <= amount) {
                new_coins[newL] = coins[i];
                newL ++;
            }
        }

        boolean [] buffer1 = new boolean[amount + 1];
        boolean [] buffer2 = new boolean[amount + 1];
        boolean [] bufferTmp = null;

        int minCoinValue = Integer.MAX_VALUE;

        for (int i = 0; i < newL; i++) {
            minCoinValue = Math.min(minCoinValue, new_coins[i]);
            buffer1[new_coins[i]] = true;
        }
        int maxCoins = amount / minCoinValue + 1;

        if (buffer1[amount]) return 1;
        int newV;

        for (int iteration = 2; iteration <= maxCoins; iteration ++ ){
            for (int v = 1; v <= amount; v++){
                if (buffer1[v]) {
                    for (int id = 0; id < newL; id ++){
                        newV = v + new_coins[id];
                        if (newV <= amount) buffer2[newV] = true;
                    }
                    buffer1[v] = false;
                }
            }

            bufferTmp = buffer1;
            buffer1 = buffer2;
            buffer2 = bufferTmp;

            if (buffer1[amount]) return iteration;
        }


        return -1;
    }
}