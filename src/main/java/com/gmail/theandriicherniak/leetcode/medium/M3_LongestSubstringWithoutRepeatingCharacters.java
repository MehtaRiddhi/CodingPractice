package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/10/16.
 */
public class M3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char [] ar = s.toCharArray();
        int L = ar.length;

        if (L <= 1) return L;

        int maxL = 1;
        int j = 0;

        boolean [] bitmap = new boolean[255];
        int [] char_pos = new int[255];

        for (int i = 0; i < L; i++){
            char ch = ar[i];

            if (bitmap[(int) ch]){
                while (j <= char_pos[(int) ch]){
                    char ch1 = ar[j];
                    bitmap[(int) ch1] = false;
                    j++;
                }
            }
            bitmap[(int) ch] = true;
            maxL = Math.max(maxL, i - j + 1);
            char_pos[(int) ch] = i;
        }

        return maxL;
    }
}
