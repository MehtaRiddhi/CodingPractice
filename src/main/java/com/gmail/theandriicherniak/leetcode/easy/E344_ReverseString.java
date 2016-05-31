package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 5/31/16.
 */
public class E344_ReverseString {
    public String reverseString(String s) {
        if (s.equals("")) return s;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
