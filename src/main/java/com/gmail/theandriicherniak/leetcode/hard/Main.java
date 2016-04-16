package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/16/16.
 */
public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H10_RegularExpressionMatching m = new H10_RegularExpressionMatching();
        System.out.println(m.isMatch("aa", "a*"));
        System.out.println(m.isMatch("aab", "c*a*b"));
        System.out.println(m.isMatch("a", "c*a"));
        System.out.println(m.isMatch("a", "c*"));
        System.out.println(m.isMatch("a", "a*"));
    }
}
