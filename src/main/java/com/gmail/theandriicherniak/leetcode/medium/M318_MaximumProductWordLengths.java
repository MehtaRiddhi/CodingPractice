package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/5/16.
 */
public class M318_MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        int result = 0;
        int L = words.length;
        if (L <= 1) return 0;
        int [] bitmap = new int[L];
        int [] wL = new int[L];

        for (int i = 0; i < L; i++){
            char [] ar = words[i].toCharArray();
            wL[i] = ar.length;
            for (int j = 0; j < wL[i]; j++) bitmap[i] |= 1 << (ar[j] - 'a');
        }
        for (int i = 0; i < L - 1; i++){
            for (int j = i + 1; j < L; j++){
                if ((bitmap[i] & bitmap[j]) == 0) result = Math.max(result, wL[i] * wL[j]);
            }
        }
        return result;
    }
}
