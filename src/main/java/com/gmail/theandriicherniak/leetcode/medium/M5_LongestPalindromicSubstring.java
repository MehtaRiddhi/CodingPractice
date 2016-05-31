package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/19/16.
 */
public class M5_LongestPalindromicSubstring {
    private void expand(char [] ar, int L, int from, int to, int [] result){
        while (from >= 0 && to < L && ar[from] == ar[to]){
            result[0] = from;
            result[1] = to;
            from --;
            to ++;
        }
    }
    public String longestPalindrome(String s) {
        int L = s.length();
        if (L <= 1) return s;
        char [] ar = s.toCharArray();

        int from = 0;
        int to = 1;
        int maxL = 0;
        int curL;

        int [] boundaries = new int[2];

        for (int i = 0; i < L; i++){
            expand(ar, L, i, i, boundaries);
            curL = boundaries[1] - boundaries[0] + 1;

            if (curL > maxL){
                maxL = curL;
                from = boundaries[0];
                to = boundaries[1];
            }
        }

        for (int i = 0; i < L - 1; i++){
            expand(ar, L, i, i + 1, boundaries);
            curL = boundaries[1] - boundaries[0] + 1;


            if (curL > maxL){
                maxL = curL;
                from = boundaries[0];
                to = boundaries[1];
            }
        }

        return s.substring(from, to + 1);
    }
}
