package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/17/16.
 */
public class M190_ReverseBits {
    public int reverseBits(int n) {
        int bitMask = 1;
        int result = 0;
        for (int i = 1; i <= 32; i++){
            result <<= 1;

            if ((bitMask & n) != 0) result += 1;
            bitMask <<= 1;
        }

        return result;
    }
}
