package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class E13_RomanInteger {
    public int romanToInt(String s) {
        int L = s.length();
        if (L == 0) return 0;

        int pos = 0;
        int result = 0;
        while (pos <= L - 1){
            if (s.charAt(pos) == 'I'){
                if (pos < L-1 && s.charAt(pos + 1) == 'V') {
                    result += 4;
                    pos += 2;
                }else if (pos < L-1 && s.charAt(pos + 1) == 'X'){
                    result += 9;
                    pos += 2;
                }else {
                    result++;
                    pos ++;
                }
            } else if (s.charAt(pos) == 'X'){
                if (pos < L-1 && s.charAt(pos + 1) == 'L'){
                    result += 40;
                    pos += 2;
                } else if (pos < L-1 && s.charAt(pos + 1) == 'C'){
                    result += 90;
                    pos += 2;
                } else {
                    result += 10;
                    pos ++;
                }
            } else if (s.charAt(pos) == 'C'){
                if (pos < L-1 && s.charAt(pos + 1) == 'D'){
                    result += 400;
                    pos += 2;
                } else if (pos < L-1 && s.charAt(pos + 1) == 'M'){
                    result += 900;
                    pos += 2;
                } else {
                    result += 100;
                    pos ++;
                }
            } else if (s.charAt(pos) == 'V'){
                result += 5;
                pos ++;
            } else if (s.charAt(pos) == 'L'){
                result += 50;
                pos ++;
            } else if (s.charAt(pos) == 'D'){
                result += 500;
                pos ++;
            } else if (s.charAt(pos) == 'M'){
                result += 1000;
                pos ++;
            }
        }

        return result;
    }
}
