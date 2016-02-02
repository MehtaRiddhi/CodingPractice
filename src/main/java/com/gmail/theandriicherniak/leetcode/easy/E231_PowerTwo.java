package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/1/16.
 */
public class E231_PowerTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        boolean result = true;
        while (result && (n > 1)){
            int mult = n / 2;
            if (mult * 2 != n) result = false;
            n = mult;
        }
        return result;
    }
}
