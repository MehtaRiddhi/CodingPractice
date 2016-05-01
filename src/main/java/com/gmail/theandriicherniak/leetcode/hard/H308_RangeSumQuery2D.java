package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/1/16.
 */
public class H308_RangeSumQuery2D {
    private int [][] curSum;
    private int [][] curVal;
    private int Rmax;
    private int Cmax;

    public H308_RangeSumQuery2D(int[][] matrix) {
        int R = matrix.length;
        if (R == 0) {
            Rmax = 0;
            Cmax = 0;
        }else {
            int C = matrix[0].length;
            curSum = new int[R + 1][C + 1];
            curVal = new int[R][C];

            Rmax = R;
            Cmax = C;

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    update(r, c, matrix[r][c]);
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - curVal[row][col];
        curVal[row][col] = val;

        for (int r = row + 1; r <= Rmax; r += r & (-r)){
            for (int c = col + 1; c <= Cmax; c += c & (-c)){
                curSum[r][c] += diff;
            }
        }
    }

    private int sum(int row, int col){
        int result = 0;
        for (int r = row + 1; r > 0; r -= r & (-r)){
            for (int c = col + 1; c > 0; c -= c & (-c)){
                result += curSum[r][c];
            }
        }
        return result;
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        if (Rmax == 0 || Cmax == 0) return 0;

        return sum(row2, col2) - sum(row1 - 1, col2) - sum(row2, col1 - 1) + sum(row1 - 1, col1 - 1);
    }
}
