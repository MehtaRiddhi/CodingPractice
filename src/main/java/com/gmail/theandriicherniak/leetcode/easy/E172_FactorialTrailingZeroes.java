package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/12/16.
 */
public class E172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int zero_cnt_5 = 0;
        for (int power_5 = 5; n / power_5 >= 1; power_5 *= 5){
            zero_cnt_5 += n/power_5;
        }
        return zero_cnt_5;
    }
}
