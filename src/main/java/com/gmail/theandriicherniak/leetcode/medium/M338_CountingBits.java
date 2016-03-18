package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/17/16.
 */
public class M338_CountingBits {
    public int[] countBits(int num) {
        int [] result = new int[num + 1];

        if (num == 0) return result;
        int lowerLimit = 1;
        int upperLimit = 1;

        result[1] = 1;

        while (lowerLimit <= num){
            lowerLimit <<= 1;
            upperLimit <<= 1;
            upperLimit += 1;

            int bitMask = upperLimit & (~lowerLimit);

            for (int n = lowerLimit; n <= Math.min(num, upperLimit); n++){
                int diff = n & bitMask;
                result[n] = 1 + result[diff];
//                System.out.println(n + " " + result[n]);
            }
        }

        return result;
    }
}
