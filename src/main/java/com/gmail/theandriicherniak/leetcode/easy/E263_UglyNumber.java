package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/12/16.
 */
public class E263_UglyNumber {
    private int factor_helper(int num, int factor){
        int result = num;
        while (result % factor == 0) result /= factor;
        return result;
    }
    public boolean isUgly(int num) {
        int [] factors = new int[]{2, 3, 5};
        if (num == 1) return true;
        if (num == 0) return false;

        int result = num;
        result = factor_helper(result, factors[0]);

        result = factor_helper(result, factors[1]);

        result = factor_helper(result, factors[2]);

        if (result != 1) return false;
        return true;
    }
}
