package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/26/16.
 */
import java.util.*;

public class M127_WordLadder {

    private HashSet<String> setTransition(HashSet<String> from, Set<String> configurations, int wordLen){
        HashSet<String> result = new HashSet<String>();
        if (from.isEmpty()) return result;
        String new_s;

        for (String s : from){
            for (int i = 0; i < wordLen; i++){
                StringBuilder sb = new StringBuilder(s);

                for (char ch = 'a'; ch <= 'z'; ch ++) {
                    sb.setCharAt(i, ch);
                    new_s = sb.toString();
                    if (!new_s.equals(s) && configurations.contains(new_s)) result.add(new_s);
                }
            }
        }
        return result;
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        int wordLen = beginWord.length();

        HashSet<String> forward = new HashSet<String>();
        HashSet<String> backwords = new HashSet<String>();

        int maxIterations = wordList.size();

        forward.add(beginWord);
        backwords.add(endWord);

        int iter = 1;

        while (iter <= maxIterations){
            forward = setTransition(forward, wordList, wordLen);

            iter ++;
            for (String s : forward){
                if (backwords.contains(s)) return iter;
            }
            backwords = setTransition(backwords, wordList, wordLen);

            iter ++;
            for (String s : backwords){
                if (forward.contains(s)) return iter;
            }
        }

        return 0;
    }
}
