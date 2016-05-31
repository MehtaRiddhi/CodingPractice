package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 5/31/16.
 */
public class E345_ReverseVowels {
    private boolean isVovel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U')
            return true;
        return false;
    }

    private void swap(char[] ar, int p1, int p2) {
        char ch = ar[p1];
        ar[p1] = ar[p2];
        ar[p2] = ch;
    }

    public String reverseVowels(String s) {
        int L = s.length();
        if (L <= 1) return s;
        char[] ar = s.toCharArray();
        int p1 = 0;
        int p2 = L - 1;

        while (p1 < p2) {
            while (p1 < L && !isVovel(ar[p1])) p1++;
            while (p2 > p1 && !isVovel(ar[p2])) p2--;
            if (p1 < p2) swap(ar, p1, p2);
            p1++;
            p2--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : ar) sb.append(ch);
        return sb.toString();
    }
}
