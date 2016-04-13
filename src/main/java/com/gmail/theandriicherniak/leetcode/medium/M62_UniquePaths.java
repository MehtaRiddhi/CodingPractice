package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/13/16.
 */
public class M62_UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] buffer = new int[m][n];

        buffer[0][0] = 1;

        for (int r = 0; r < m; r ++){
            for (int c = 0; c < n; c++){
                if (r > 0 && c > 0) buffer[r][c] = buffer[r-1][c] + buffer[r][c-1];
                else if (r == 0 && c > 0) buffer[r][c] = buffer[r][c-1];
                else if (r > 0 && c == 0) buffer[r][c] = buffer[r-1][c];
            }
        }

        return buffer[m-1][n-1];
    }
}
