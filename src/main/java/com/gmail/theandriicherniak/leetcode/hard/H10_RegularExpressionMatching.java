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
        for (int j = 1; j <= Lp; j++){
            if (p_ar[j-1] == '*') dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= Ls; i++){
            for (int j = 1; j <= Lp; j++){
                if (p_ar[j-1] != '*'){
                    if (s_ar[i-1] == p_ar[j-1] || p_ar[j-1] == '.') dp[i][j] = dp[i-1][j-1];
                }else{
                    if (s_ar[i-1] != p_ar[j-1] && p_ar[j-1] == '.') dp[i][j] = dp[i][j-2];
                    else dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                }
            }
        }

       return dp[Ls][Lp];

    }
}
