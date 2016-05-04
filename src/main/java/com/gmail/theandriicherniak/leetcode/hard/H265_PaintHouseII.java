package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/4/16.
 */
public class H265_PaintHouseII {

    private static void minExclude(int [] input, int [] output){
        output[0] = Integer.MAX_VALUE;
        for (int c = 1; c <= input.length - 1; c++){
            output[c] = Math.min(output[c-1], input[c-1]);
        }
        int minRev = Integer.MAX_VALUE;
        for (int c = input.length - 2; c >= 0; c--){
            minRev = Math.min(minRev, input[c+1]);
            output[c] = Math.min(output[c], minRev);
        }
    }

    public int minCostII(int[][] costs) {
        int L = costs.length;
        if (L == 0) return 0;
        int C = costs[0].length;
        if (C == 0) return 0;

        int[] buffer = new int[C];
        int [] minExcludeOutput = new int[C];

        for (int c = 0; c < C; c++) buffer[c] = costs[0][c];

        for (int i = 1; i < L; i++){
            minExclude(buffer, minExcludeOutput);

            for (int c = 0; c < C; c++){
                buffer[c] = minExcludeOutput[c] + costs[i][c];
            }
        }


        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < C; i++){
            minCost = Math.min(minCost, buffer[i]);
        }

        return minCost;
    }
}
