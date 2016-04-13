package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M256_PaintHouse {
    public int minCost(int[][] costs) {
        int L = costs.length;
        if (L == 0) return 0;
        int [][] buffer = new int[L][3];

        buffer[0][0] = costs[0][0];
        buffer[0][1] = costs[0][1];
        buffer[0][2] = costs[0][2];


        for (int i = 1; i < L; i++){
            buffer[i][0] = costs[i][0] + Math.min(buffer[i-1][1], buffer[i-1][2]);
            buffer[i][1] = costs[i][1] + Math.min(buffer[i-1][0], buffer[i-1][2]);
            buffer[i][2] = costs[i][2] + Math.min(buffer[i-1][0], buffer[i-1][1]);

        }

        return Math.min(Math.min(buffer[L-1][0], buffer[L-1][1]), buffer[L-1][2]);
    }
}
