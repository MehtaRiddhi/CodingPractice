package com.gmail.theandriicherniak.leetcode.hard;

import java.util.Stack;

/**
 * Created by andriicherniak on 5/12/16.
 */
public class H224_BasicCalculator {
    private int rangeResult(char [] data, int [] boundaries){
        int sign = 1;
        int from = boundaries[0];
        int to = boundaries[1];

        int result = 0;
        int number = 0;

        while (from <= to){
            char ch = data[from];
            if (ch == '+' || ch == '-' || ch == '(' || ch == ')'){

                result += sign * number;
                number = 0;

                if (ch == '+') sign = 1;
                if (ch == '-') sign = -1;
                if (ch == ')') {
                    boundaries[1] = from;
                    return result;
                }
                if (ch == '('){
                    int [] new_boundaries = new int[]{from + 1, to};
                    int rr = rangeResult(data, new_boundaries);

                    result += sign * rr;
                    sign = 1;
                    from = new_boundaries[1];
                }

            }else number = 10 * number + (ch - '0');
            from ++;
        }

        return result;
    }

    public int calculate(String s) {
        char [] ar = ("+(" + s.replace(" ", "") + ")").toCharArray();
        int L = ar.length;
        if (L == 0) return 0;

        int [] boundaries = new int[]{0, L-1};

        return rangeResult(ar, boundaries);
    }
}