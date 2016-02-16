package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/15/16.
 */
public class E7_ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = 1;
        int result = 0;
        if (x < 0) sign = -1;

        x = Math.abs(x);
        while (x > 0){
            if ((result*10+x%10-x%10)/10 != result) return 0;
            result = 10 * result + x % 10;
            x /= 10;
        }

        return sign * result;
    }
}
