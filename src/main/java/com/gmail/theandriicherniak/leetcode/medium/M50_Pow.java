package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/14/16.
 */
public class M50_Pow {
    private double powHelper(double x, int n){
        if (n == 0) return 1.0;
        if (n == 1) return x;

        double r = powHelper(x, n / 2);
        if (n % 2 == 0 ) return r * r;
        else return r * r * x;
    }
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / powHelper(x, -n);
        else return powHelper(x, n);
    }
}
