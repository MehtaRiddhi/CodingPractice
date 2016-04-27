package com.gmail.theandriicherniak.leetcode.medium;

import java.util.HashSet;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M127_WordLadder ladder = new M127_WordLadder();
        String [] words = new String[]{"hot","dot","dog","lot","log"};
        HashSet<String> set = new HashSet<String>();
        for (String word : words) set.add(word);

        System.out.println(ladder.ladderLength("hit", "cog", set));
    }
}