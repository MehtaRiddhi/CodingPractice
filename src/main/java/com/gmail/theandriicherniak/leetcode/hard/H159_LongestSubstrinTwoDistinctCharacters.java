package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/10/16.
 */

public class H159_LongestSubstrinTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char [] ar = s.toCharArray();
        int L = ar.length;
        if (L <= 2) return L;
        int maxL = 0;

        Character ch1 = null, ch2 = null;
        int [] char_position = new int[255];
        int j = 0;

        for (int i = 0; i < L; i ++){
            char ch = ar[i];
            if (ch1 == null || ch2 == null || ch1 == ch || ch2 == ch){
                if (ch1 == null) ch1 = ch;
                else if (ch1 != ch) ch2 = ch;
            }else{
                j = Math.min(char_position[(int) ch1], char_position[(int) ch2]) + 1;
                if (char_position[(int) ch2] > char_position[(int) ch1]) ch1 = ch2;
                ch2 = ch;
            }
            maxL = Math.max(maxL, i - j + 1);
            char_position[(int) ch] = i;
        }

        return maxL;
    }
}
