package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) return 0;
        int C = matrix[0].length;
        if (C == 0) return 0;

        int L;

        int [][] buffer = new int[R][C];
        int maxL = 0;
        int L1;
        int L2;

        for (int c = 0; c < C; c++){
            buffer[0][c] = matrix[0][c] - '0';
            maxL = Math.max(maxL, buffer[0][c]);
        }

        for (int r = 0; r < R; r++){
            buffer[r][0] = matrix[r][0] - '0';
            maxL = Math.max(maxL, buffer[r][0]);
        }

        for (int r = 1; r < R; r ++){
            for (int c = 1; c < C; c++){
                L = matrix[r][c] - '0';
                if (L == 0) buffer[r][c] = 0;
                else {
                    L1 = buffer[r-1][c];
                    L2 = buffer[r][c-1];
                    if (L1 != L2) buffer[r][c] = Math.min(L1, L2) + 1;
                    else buffer[r][c] = (matrix[r-L1][c-L1] == '1') ? L1 + 1 : L1;
                }
                maxL = Math.max(maxL, buffer[r][c]);
            }
        }

        return maxL * maxL;
    }
}
