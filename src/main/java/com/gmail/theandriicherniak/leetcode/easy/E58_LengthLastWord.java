package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/12/16.
 */
public class E58_LengthLastWord {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;
        String[] ar = s.split(" ");
        if (ar.length == 0) return 0;
        return ar[ar.length - 1].length();
    }
}
