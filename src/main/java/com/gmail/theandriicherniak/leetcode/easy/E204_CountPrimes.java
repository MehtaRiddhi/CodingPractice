package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/16/16.
 */
public class E204_CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        if (n == 3) return 1;

        boolean [] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++){
            isPrime[i] = true;
        }

        int n_sqrt = (int) Math.sqrt(n) + 1;
        int multiplier;

        for (int i = 2; i <= n_sqrt; i++){
            if (isPrime[i]){
                multiplier = 2;
                while (multiplier * i <= n){
                    isPrime[multiplier * i] = false;
                    multiplier ++;
                }
            }
        }

        int pCnt = 0;
        for (int i = 2; i <= n - 1; i++){
            if (isPrime[i]) pCnt ++;
        }
        return pCnt;
    }
}
