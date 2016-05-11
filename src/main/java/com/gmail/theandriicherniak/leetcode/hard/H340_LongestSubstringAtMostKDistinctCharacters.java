package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/11/16.
 */
public class H340_LongestSubstringAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char [] ar = s.toCharArray();
        int L = ar.length;
        if (L == 0) return 0;
        if (k == 0) return 0;
        if (L <= k) return L;
        int j = 0;

        int [] char_position = new int[255];
        boolean [] char_observed = new boolean[255];
        int distinct_chars = 0;
        int maxL = 1;

        for (int i = 0; i < L; i++){
            char ch = ar[i];

            if (!char_observed[ch]){
                char_observed[ch] = true;

                distinct_chars ++;

                if (distinct_chars > k){
                    while (j <= i && distinct_chars > k){
                        char ch1 = ar[j];
                        if (char_observed[ch1] && char_position[ch1] == j){
                            char_observed[ch1] = false;
                            distinct_chars --;
                        }
                        j++;
                    }
                }
            }

            char_position[ch] = i;
            maxL = Math.max(maxL, i - j + 1);
        }

        return maxL;
    }
}
