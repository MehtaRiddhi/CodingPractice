package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/17/16.
 */
public class M191_Number1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        int bitMask = 1;

        for(int i=1; i<= 32; i++){
            if((n & bitMask) != 0){
                count++;
            }
            bitMask <<= 1;

        }
        return count;
    }

}
