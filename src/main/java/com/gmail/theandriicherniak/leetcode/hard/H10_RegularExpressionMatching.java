package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 2/29/16.
 */
public class H10_RegularExpressionMatching {
    char [] s_ar;
    char [] p_ar;
    int Ls;
    int Lp;
    boolean[][] dp;

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        s_ar = s.toCharArray();
        p_ar = p.toCharArray();

        Ls = s_ar.length;
        Lp = p_ar.length;

        dp = new boolean[Ls + 1][Lp + 1];

        dp[0][0] = true;

        for (int j = 0; j < Lp; j++) {
            if (p_ar[j] == '*' && dp[0][j-1]) dp[0][j+1] = true;
        }

        for (int i = 0; i < Ls; i++){
            for (int j = 0; j < Lp; j++){
                if (s_ar[i] == p_ar[j] || p_ar[j] == '.') dp[i + 1][j + 1] = dp[i][j];
                if (p_ar[j] == '*'){
                    if (p_ar[j-1] != s_ar[i] && p_ar[j-1] != '.') dp[i+1][j+1] = dp[i+1][j-1];
                    else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1]);
                    }
                }
            }
        }

        return dp[Ls][Lp];

    }
}
