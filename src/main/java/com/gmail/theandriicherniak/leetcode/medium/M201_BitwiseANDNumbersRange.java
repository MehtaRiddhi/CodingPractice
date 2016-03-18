package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/17/16.
 */
public class M201_BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        long upperLimit = 1;
        while (upperLimit <= m) {
            upperLimit <<= 1;
        }

        if (n > upperLimit) return 0;

        int bitMap = m;
        for (long i = m; i <= Math.min(n, upperLimit); i++) {
            bitMap &= i;
        }
        return bitMap;
    }
}
