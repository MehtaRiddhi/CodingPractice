package com.gmail.theandriicherniak.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H140_WordBreakII words = new H140_WordBreakII();
        Set<String> wordDict = new HashSet<String>();

        for (String s : new String[]{"aaaa","aaa"}){
            wordDict.add(s);
        }
        System.out.println(words.wordBreak(
                "aaaaaaa",
                wordDict));


    }
}
