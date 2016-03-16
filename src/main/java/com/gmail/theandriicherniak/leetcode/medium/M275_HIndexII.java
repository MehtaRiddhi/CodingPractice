package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/16/16.
 */
public class M275_HIndexII {
    private int maxValidH(int[] citations, int L, int pos){
        int geCnt = L - pos;
        return Math.min(geCnt, citations[pos]);
    }

    private int getMaxH(int[] citations, int L, int from, int to){
        if (from == to) return maxValidH(citations, L, from);
        if (to - from <= 1){
            int h1 = maxValidH(citations, L, from);
            int h2 = maxValidH(citations, L, from + 1);
            return Math.max(h1, h2);
        }else {
            int midId = (from + to) / 2;
            int h = maxValidH(citations, L, midId);
            int h1 = h;
            if (citations[midId] > h) h1 = getMaxH(citations, L, from, midId);
            else h1 = getMaxH(citations, L, midId + 1, to);

            return Math.max(h, h1);
        }
    }

    public int hIndex(int[] citations) {
        int L = citations.length;
        if (L == 0) return 0;

        return getMaxH(citations, L, 0, L - 1);

    }
}
