package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class E223_RectangeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int [] r1 = {A, B, C, D};
        int [] r2 = {E, F, G, H};


        long s1 = (r1[2] - r1[0]) * (r1[3] - r1[1]);
        long s2 = (r2[2] - r2[0]) * (r2[3] - r2[1]);

        long lx = Math.max(r1[0], r2[0]);
        long ly = Math.max(r1[1], r2[1]);

        long rx = Math.min(r1[2], r2[2]);
        long ry = Math.min(r1[3], r2[3]);

        long intersect = (rx - lx) * (ry - ly);
        if (((rx - lx) < 0) || ((ry - ly) < 0)) intersect = 0L;
        long result = s1 + s2 - intersect;

        return (int) result;
    }
}
