package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/20/16.
 */
public class H214_ShortestPalindrome {
    private boolean isPalindrome(char[] ar, int from, int to){
        while (from < to){
            if (ar[from] != ar[to]) return false;
            from ++;
            to --;
        }

        return true;
    }
    public String shortestPalindrome(String s) {
        char [] s_ar = s.toCharArray();
        int L = s_ar.length;
        if (L <= 1) return s;
        int LL = 2 * L;


        char [] buffer = new char[LL];

        for (int i = 0; i < L; i++) {
            buffer[i + L] = s_ar[i];
        }

        long hash1 = 0;
        long hash2 = 0;
        long ALPHA = 29;
        long POW = 1;
        long MOD = 1000000007;

        int from = 0, to = 0;

        for (int i = 0; i < L; i++){
            hash1 = (hash1 * ALPHA + (s_ar[i] - 'a' + 1)) % MOD;
            hash2 = (hash2 + (s_ar[i] - 'a' + 1) * POW) % MOD;
            POW = POW * ALPHA % MOD;
            if (hash1 == hash2) to = i;
        }


        from += L - 1;
        to += L + 1;
        while (to < LL){
            buffer[from] = buffer[to];
            from --;
            to ++;
        }

        from ++;
        to --;


        StringBuilder sb = new StringBuilder();
        for (int i = from; i <= to; i++) sb.append(buffer[i]);
        return sb.toString();
    }
}
