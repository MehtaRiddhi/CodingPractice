package com.gmail.theandriicherniak.leetcode.hard;

import java.util.HashSet;

public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running hard examples");

        H126_WordLadderII ladder = new H126_WordLadderII();
        String[] wordList = new String[]{"hot","dot","dog","lot","log"};
        HashSet<String> set = new HashSet<String>();
        for (String word : wordList) set.add(word);

        System.out.println(ladder.findLadders("hit", "cog", set));
    }
}
