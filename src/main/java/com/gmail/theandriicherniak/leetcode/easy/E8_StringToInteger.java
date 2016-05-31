package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 5/31/16.
 */
public class E8_StringToInteger {
    public int myAtoi(String str) {
        long result = 0;
        char[] ar = str.toCharArray();
        int L = ar.length;
        if (L == 0) return 0;
        long sign = 1;

        int i = 0;

        while (ar[i] == ' ' && i < L){
            i ++;
        }
        if (ar[i] == '-'){
            sign = -1;
            i++;
        }else if (ar[i] == '+') i++;

        long minV = Integer.MIN_VALUE;
        long maxV = Integer.MAX_VALUE;

        while (i < L && (ar[i] - '0' >= 0) && (ar[i] - '0' <= 9)){
            result = 10 * result + (ar[i] - '0');
            if (sign * result > maxV) return (int) maxV;
            if (sign * result < minV) return (int) minV;
            i++;
        }

        result *= sign;

        return (int) result;
    }
}
