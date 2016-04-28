package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class H44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        char [] s_ar = s.toCharArray();
        char [] p_ar = p.toCharArray();
        int Ls = s_ar.length;
        int Lp = p_ar.length;


        boolean[][] match = new boolean[Ls + 1][Lp + 1];

        match[0][0] = true;
        for (int j = 1; j <= Lp; j++) match[0][j] = match[0][j-1] && p_ar[j-1] == '*';

        for (int i = 1; i <= Ls; i++){
            for (int j = 1; j <= Lp; j++){
                if (s_ar[i-1] == p_ar[j-1] || p_ar[j-1] == '?') match[i][j] = match[i-1][j-1];
                else if (p_ar[j-1] == '*') match[i][j] = match[i][j-1] || match[i-1][j];
            }
        }
        return match[Ls][Lp];
    }
}
