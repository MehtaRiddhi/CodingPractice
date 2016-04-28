package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/28/16.
 */
import java.util.*;

public class H282_ExpressionOperators {
    private void DFS(List<String> result, StringBuilder sb, char [] path, int [] digits, long prefixVal, long prevVal, int pos, int L, int target){

        if (pos >= L) {
            if (prefixVal + prevVal == target) {
                sb.setLength(0);

                for (int i = 0; i < 2 * L - 1; i++){
                    if (path[i] != ' ') sb.append(path[i]);
                }
                result.add(sb.toString());
            }

        }else {
            int curVal = 0;
            for (int i = pos; i < L; i++) {
                curVal = curVal * 10 + digits[i];

                path[2 * pos - 1] = '+';
                DFS(result, sb, path, digits, prefixVal + prevVal, curVal, i + 1, L, target);

                path[2 * pos - 1] = '-';
                DFS(result, sb, path, digits, prefixVal + prevVal, -curVal, i + 1, L, target);

                path[2 * pos - 1] = '*';
                DFS(result, sb, path, digits, prefixVal, prevVal * curVal, i + 1, L, target);

                path[2 * pos - 1] = ' ';

                if (curVal == 0) break;
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        char [] ar = num.toCharArray();
        int L = ar.length;

        if (L == 1 && Integer.parseInt(num) == target) result.add(num);
        if (L <= 1) return result;

        int [] digits = new int[L];
        char [] path = new char[2 * L];
        for (int i = 0; i < L; i++) {
            digits[i] = ar[i] - '0';
            path[2 * i] = ar[i];
        }

        StringBuilder sb = new StringBuilder();

        long curVal = 0;
        for (int i = 0; i < L; i++){
            curVal = curVal * 10 + digits[i];

            DFS(result, sb, path, digits, 0, curVal, i + 1, L, target);

            if (curVal == 0) break;

        }

        return result;
    }
}
