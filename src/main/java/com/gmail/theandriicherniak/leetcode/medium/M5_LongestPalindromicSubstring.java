package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/19/16.
 */
public class M5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ar = s.toCharArray();
        int L = ar.length;

        if (L == 1) sb.append(ar[0]);
        if (L == 2) {
            if (ar[0] == ar[1]) {
                sb.append(ar[0]);
                sb.append(ar[1]);
            }
        }
        if (L <= 2) return sb.toString();

        int bestFrom = 0, bestTo = 0, bestL = 1;
        int from, to;

        for (int c = 1; c <= L - 2; c++) {
            from = c - bestL / 2;
            to = c + bestL / 2;

            if (from >= 0 && to <= L - 1 && ar[from] == ar[to]) {
                from = c - 1;
                to = c + 1;
                while (from >= 0 && to <= (L - 1) && ar[from] == ar[to]) {
                    if (to - from + 1 > bestL) {
                        bestL = to - from + 1;
                        bestFrom = from;
                        bestTo = to;
                    }
                    from--;
                    to++;
                }
            }
        }

        for (int c = 0; c <= L - 2; c++) {
            from = c - bestL / 2 + 1;
            to = c + bestL / 2;

            if (from >= 0 && to <= L - 1 && ar[from] == ar[to]) {
                from = c;
                to = c + 1;
                while (from >= 0 && to <= (L - 1) && ar[from] == ar[to]) {
                    if (to - from + 1 > bestL) {
                        bestL = to - from + 1;
                        bestFrom = from;
                        bestTo = to;
                    }
                    from--;
                    to++;
                }
            }
        }

        for (int i = bestFrom; i <= bestTo; i++) {
            sb.append(ar[i]);
        }
        return sb.toString();
    }
}
