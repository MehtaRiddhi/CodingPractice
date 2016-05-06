package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 5/6/16.
 */
public class E326_PowerThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        double p = Math.log(n)/Math.log(3);
        return (Math.pow(3, Math.round(p)) == n);
    }
}
