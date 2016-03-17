package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/1/16.
 */
public class E231_PowerTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int bitMask = 1;
        int count = 0;
        for(int i=1; i<= 32; i++){
            if((n & bitMask) != 0){
                count++;
            }
            bitMask <<= 1;
            if (count > 1) return false;
        }
        return (count == 1);
    }
}
