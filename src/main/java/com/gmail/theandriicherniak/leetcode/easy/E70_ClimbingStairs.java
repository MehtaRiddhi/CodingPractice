package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/1/16.
 */
public class E70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int [] climbs = new int[n];

        if (n >= 1) climbs[0] = 1;
        if (n >= 2) climbs[1] = 2;
        for (int i = 3; i <= n; i++){
            climbs[i-1] = climbs[i-2] + climbs[i-3];
        }
        return climbs[n-1];
    }
}
