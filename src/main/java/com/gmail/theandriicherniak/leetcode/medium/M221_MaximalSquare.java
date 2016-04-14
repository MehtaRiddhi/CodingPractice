package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M221_MaximalSquare {
    private int helper(int [][] buffer, int r1, int c1, int r2, int c2){
        return buffer[r2][c2] - buffer[r1-1][c2] - (buffer[r2][c1-1] - buffer[r1-1][c1-1]);
    }
    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) return 0;
        int C = matrix[0].length;
        if (C == 0) return 0;

        int [][] buffer = new int[R+1][C+1];
        for (int r = 1; r <= R; r ++){
            for (int c = 1; c <= C; c++){
                buffer[r][c] = Character.getNumericValue(matrix[r-1][c-1]) + (buffer[r-1][c] - buffer[r-1][c-1]) + buffer[r][c-1];
            }
        }

        int rNext;
        int cNext;
        int aNext;
        int sNext;

        int result = 0;

        for (int r = 1; r <= R; r ++){
            for (int c = 1; c <= C; c++){
                if (matrix[r-1][c-1] == '1'){

                    result = Math.max(result, 1);

                    rNext = r + 1;
                    cNext = c + 1;

                    while (rNext <= R && cNext <= C && matrix[rNext - 1][cNext - 1] == '1'){
                        aNext = (rNext - r + 1)*(rNext - r + 1);
                        sNext = helper(buffer, r, c, rNext, cNext);
                        if (aNext == sNext) result = Math.max(result, aNext);

                        rNext += 1;
                        cNext += 1;
                    }
                }
            }
        }
        
        return result;
    }
}
