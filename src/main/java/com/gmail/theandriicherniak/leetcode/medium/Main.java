package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M5_LongestPalindromicSubstring p = new M5_LongestPalindromicSubstring();
        String result = p.longestPalindrome("abaaba");
        System.out.println(result.length());
    }
}