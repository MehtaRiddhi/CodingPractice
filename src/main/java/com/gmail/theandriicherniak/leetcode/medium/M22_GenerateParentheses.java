package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/29/16.
 */
import java.util.*;

public class M22_GenerateParentheses {
    private void configuration(int n, int openingLeft, int closingLeft, int openConfiguration, char[] buffer, List<String> result){
        if (openConfiguration < 0) return;

        if (openingLeft == 0 && closingLeft == 0 && openConfiguration == 0){

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2*n; i++) sb.append(buffer[i]);
            result.add(sb.toString());
        }

        if (openingLeft >= 0 && closingLeft >= 0){
            if (openingLeft > 0) {
                buffer[2*n-openingLeft-closingLeft] = '(';
                configuration(n, openingLeft - 1, closingLeft, openConfiguration + 1, buffer, result);
            }
            if (closingLeft > 0){
                buffer[2*n-openingLeft-closingLeft] = ')';
                configuration(n, openingLeft, closingLeft - 1, openConfiguration - 1, buffer, result);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) return result;
        char [] buffer = new char[2*n];

        configuration(n, n, n, 0, buffer, result);

        System.out.println(result);

        return result;
    }
}
