package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/14/16.
 */
public class M91_DecodeWays {
    public int numDecodings(String s) {
        char [] digits = s.toCharArray();
        int L = digits.length;
        if (L == 0) return 0;

        int [] numbers = new int[L];
        int [] buffer = new int[L];

        for (int i = 0; i < L; i++) numbers[i] = digits[i] - '0';
        if (numbers[0] > 0) buffer[0] = 1;

        for (int i = 1; i < L; i++){
            if (numbers[i] > 0) buffer[i] = buffer[i - 1];
            if (numbers[i - 1] > 0 && (10 * numbers[i - 1] + numbers[i]) <= 26) {
                buffer[i] += (i - 2 >= 0) ? buffer[i - 2] : 1;
            }
        }

        return buffer[L-1];
    }
}
