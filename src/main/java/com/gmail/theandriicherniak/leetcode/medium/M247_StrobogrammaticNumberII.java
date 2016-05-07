package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/6/16.
 */

import java.util.*;

public class M247_StrobogrammaticNumberII {
    char[][] pairs = new char[][]{
            new char[]{'0', '0'},
            new char[]{'1', '1'},
            new char[]{'6', '9'},
            new char[]{'9', '6'},
            new char[]{'8', '8'}};

    char[] singles = new char[]{'0', '1', '8'};

    private void helper(StringBuilder sb, int n, int pos, List<String> result){
        int leftHalf = (n&(~1)) >> 1;
        boolean isOdd = (n&1) > 0;
        int midPoint = n >> 1;

        if (pos < leftHalf){
            for (int i = 0; i < 5; i++){
                if (pos > 0 || i > 0) {
                    sb.setCharAt(pos, pairs[i][0]);
                    sb.setCharAt(n - 1 - pos, pairs[i][1]);
                    helper(sb, n, pos + 1, result);
                }
            }
        }
        if(isOdd && pos == midPoint){
            for (int i = 0; i < 3; i++) {
                sb.setCharAt(pos, singles[i]);
                helper(sb, n, pos + 1, result);
            }

        }
        if ((pos == midPoint && !isOdd) || (pos > midPoint && isOdd))
            result.add(sb.toString());
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new LinkedList<String>();
        if (n <= 0) return result;
        if (n == 1) {
            for (char ch : singles) result.add(""+ch);
            return result;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(0);

        helper(sb, n, 0, result);

        return result;
    }
}
