package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/18/16.
 */
public class M260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int bitDiff = 0;
        int a = 0;
        int b = 0;

        for (int v : nums) bitDiff ^= v;

        int bitMask = 1;
        while ((bitMask & bitDiff) == 0) bitMask <<= 1;

        for (int v : nums){
            if ((bitMask & v) != 0) a ^= v;
            else b ^= v;
        }
        
        return new int[]{a, b};
    }
}
