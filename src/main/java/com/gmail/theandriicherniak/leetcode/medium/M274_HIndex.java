package com.gmail.theandriicherniak.leetcode.medium;

import java.util.Arrays;

/**
 * Created by andriicherniak on 3/15/16.
 */
public class M274_HIndex {
    private boolean validH(int h, int geCnt){
        return (geCnt >= h);
    }

    public int hIndex(int[] citations) {
        int L = citations.length;
        if (L == 0) return 0;

        int maxH = 0;

        Arrays.sort(citations);
        for (int i = 0; i < L; i++){
            int geCnt = L - i;
            if (i == 0){
                for (int hi = 1; hi <= citations[0]; hi ++){
                    if (validH(hi, geCnt)) maxH = hi;
                }
            }
            if (i > 0 ) {
                for (int hi = citations[i - 1]; hi <= citations[i]; hi++) {
                    if (validH(hi, geCnt)) maxH = hi;
                }
            }
        }

        return maxH;
    }
}
