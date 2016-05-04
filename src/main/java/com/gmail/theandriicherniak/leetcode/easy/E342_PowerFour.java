package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 5/4/16.
 */
public class E342_PowerFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        int num1 = num & ~(num - 1);
        if (num - num1 > 0) return false;
        int ZeroCnt = Integer.numberOfTrailingZeros(num);
        if (ZeroCnt % 2 != 0) return false;
        return true;
    }
}
