package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/18/16.
 */
public class M245_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos_w1 = -1;
        int pos_w2 = -1;
        int L = words.length;
        int d = L;

        for (int i = 0; i < L; i++){
            if (!word1.equals(word2)) {
                if (words[i].equals(word1)) pos_w1 = i;
                if (words[i].equals(word2)) pos_w2 = i;
            }else{
                if (words[i].equals(word1)){
                    if (pos_w1 == -1) pos_w1 = i;
                    else {
                        if (pos_w2 == -1) pos_w2 = i;
                        else {
                            pos_w1 = pos_w2;
                            pos_w2 = i;
                        }
                    }
                }
            }
            if (pos_w1 > -1 && pos_w2 > -1) {
                d = Math.min(d, Math.abs(pos_w1 - pos_w2));
            }
        }

        return d;
    }
}
