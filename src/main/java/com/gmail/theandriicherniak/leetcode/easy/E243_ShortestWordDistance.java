package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/10/16.
 */
public class E243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos_w1 = -1;
        int pos_w2 = -1;
        int L = words.length;
        int d = L;

        for (int i = 0; i < L; i++){
            if (words[i].equals(word1)) pos_w1 = i;
            if (words[i].equals(word2)) pos_w2 = i;
            if (pos_w1 > -1 && pos_w2 > -1){
                d = Math.min(d, Math.abs(pos_w1-pos_w2));
            }
        }

        return d;
    }
}
