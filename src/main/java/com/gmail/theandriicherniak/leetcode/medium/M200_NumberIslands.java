package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/23/16.
 */
import java.util.*;

public class M200_NumberIslands {
    private void coverIsland(char[][] grid, int r, int c, int R, int C){
        if (grid[r][c] == '1') grid[r][c] = '0';
        if (r - 1 >= 0 && grid[r-1][c] == '1') coverIsland(grid, r-1, c, R, C);
        if (c - 1 >= 0 && grid[r][c-1] == '1') coverIsland(grid, r, c-1, R, C);
        if (c + 1 < C && grid[r][c + 1] == '1') coverIsland(grid, r, c + 1, R, C);
        if (r + 1 < R && grid[r+1][c] == '1') coverIsland(grid, r+1, c, R, C);
    }
    public int numIslands(char[][] grid) {
        int R = grid.length;
        if (R == 0) return 0;
        int C = grid[0].length;

        int counter = 0;

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (grid[r][c] == '1'){
                    counter ++;
                    coverIsland(grid, r, c, R, C);
                }
            }
        }

        return counter;
    }
}
