package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int R = grid.length;
        if (R == 0) return 0;
        int C = grid[0].length;
        if (C == 0) return 0;

        int[][] buffer = new int[R][C];

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){

                buffer[r][c] = grid[r][c];
                if (r > 0 && c > 0) buffer[r][c] += Math.min(buffer[r-1][c], buffer[r][c-1]);
                if (r > 0 && c == 0) buffer[r][c] += buffer[r - 1][c];
                if (r == 0 && c > 0) buffer[r][c] += buffer[r][c - 1];
            }
        }
        return buffer[R-1][C-1];
    }
}
