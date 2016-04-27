package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 4/27/16.
 */
public class E28_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int Lh = haystack.length();
        int Ln = needle.length();
        if (Ln == 0) return 0;
        if (Lh < Ln) return -1;

        boolean found;

        for (int i = 0; i <= Lh - Ln; i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                found = true;
                int j = 1;
                while (j < Ln && found) {
                    if (haystack.charAt(i + j) != needle.charAt(j)){
                        found = false;
                    }
                    j++;
                }
                if (found) return i;
            }
        }
        return -1;
    }
}
