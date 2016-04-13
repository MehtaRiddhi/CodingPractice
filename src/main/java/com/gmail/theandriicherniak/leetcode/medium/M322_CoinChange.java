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

        int [] buffer = new int[amount + 1];
        int minCoinValue = Integer.MAX_VALUE;


        for (int i = 0; i < L; i++){
            if (coins[i] <= amount) {
                new_coins[newL] = coins[i];
                buffer[coins[i]] = 1;
                minCoinValue = Math.min(minCoinValue, coins[i]);
                newL ++;
            }
        }

        int newV;

        for (int v = minCoinValue; v <= amount; v++){

            if (buffer[v] > 0){

                for (int i = 0; i < newL; i++){
                    newV = v + new_coins[i];
                    if (newV <= amount) {
                        if (buffer[newV] == 0) buffer[newV] = buffer[v] + 1;
                        else buffer[newV] = Math.min(buffer[newV], buffer[v] + 1);
                    }
                }
            }
        }

        if (buffer[amount] > 0) return buffer[amount];


        return -1;
    }
}