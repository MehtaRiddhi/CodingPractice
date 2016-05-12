package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M186_ReverseWordsStringII reverse = new M186_ReverseWordsStringII();
        char [] data = "hi!".toCharArray();
        reverse.reverseWords(data);
        for (char ch : data) System.out.print(ch);

    }
}