package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M5_LongestPalindromicSubstring_2 palindrom = new M5_LongestPalindromicSubstring_2();
        System.out.println(palindrom.longestPalindrome("babcbabcbaccba"));
        System.out.println(palindrom.longestPalindrome("bb"));

    }
}