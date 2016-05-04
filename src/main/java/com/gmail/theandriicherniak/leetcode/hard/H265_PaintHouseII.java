package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/4/16.
 */
public class H265_PaintHouseII {

    public int minCostII(int[][] costs) {
        int L = costs.length;
        if (L == 0) return 0;
        int C = costs[0].length;
        if (C == 0) return 0;

        int[][] buffer = new int[L][C];

        int prevMinCost = Integer.MAX_VALUE;
        int curMinCost;

        for (int c = 0; c < C; c++){
            buffer[0][c] = costs[0][c];
            prevMinCost = Math.min(prevMinCost, costs[0][c]);
        }

        for (int i = 1; i < L; i++){
            curMinCost = Integer.MAX_VALUE;

            for (int c = 0; c < C; c ++){
                if (buffer[i-1][c] > prevMinCost) buffer[i][c] = prevMinCost + costs[i][c];
                else {
                    int minV = Integer.MAX_VALUE;
                    for (int cc = 0; cc < C; cc ++){
                        if (c != cc) minV = Math.min(minV, buffer[i-1][cc]);
                    }
                    buffer[i][c] = minV + costs[i][c];
                }
                curMinCost = Math.min(curMinCost, buffer[i][c]);
            }
            prevMinCost = curMinCost;
        }


        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < C; i++){
            minCost = Math.min(minCost, buffer[L - 1][i]);
        }

        return minCost;
    }
}
