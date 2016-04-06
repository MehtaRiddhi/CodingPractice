package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/6/16.
 */
public class M304_RangeSumQuery2D {
    private int[][] memory;

    private boolean ok;

    public M304_RangeSumQuery2D(int[][] matrix) {
        ok = false;
        if (matrix == null) return;
        int R = matrix.length;
        if (R == 0) return;
        int C = matrix[0].length;
        if (C == 0) return;
        ok = true;

        memory = new int[R + 1][C + 1];

        for (int r = 1; r <= R; r++){
            for (int c = 1; c <= C; c++){
                memory[r][c] = matrix[r-1][c-1] + memory[r - 1][c] + (memory[r][c-1] - memory[r-1][c-1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int result = 0;
        if (!ok) return result;

        int r1 = row1 + 1;
        int r2 = row2 + 1;

        int c1 = col1 + 1;
        int c2 = col2 + 1;

        result = memory[r2][c2] - memory[r2][c1 - 1] - memory[r1 - 1][c2] + memory[r1 - 1][c1 - 1];

        return result;
    }
}
