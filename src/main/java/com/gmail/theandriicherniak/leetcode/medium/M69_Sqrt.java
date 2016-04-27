package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class M69_Sqrt {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;

        int upper = x;
        int lower = 1;
        long mid;
        long v2;
        while (lower < upper){
            if (upper - lower <= 2){
                for (long i =  upper; i >= lower; i--){
                    if (i * i <= x) return (int) i;
                }
            }
            mid = lower + (upper - lower) / 2;

            v2 = mid * mid;

            System.out.println(" mid " + mid + " v2 " + v2 + " x " + x);

            if (v2 == x) return (int) mid;
            else if (v2 > x) upper = (int)mid - 1;
            else lower = (int) mid;
        }
        return lower;
    }
}
