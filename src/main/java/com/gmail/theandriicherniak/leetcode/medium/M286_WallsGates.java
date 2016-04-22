package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/21/16.
 */

public class M286_WallsGates {
    public void wallsAndGates(int[][] rooms) {
        int R  = rooms.length;
        if (R == 0) return;
        int C = rooms[0].length;
        if (C == 0) return;

        int[][] buffer1 = new int[R*C][2];
        int[][] buffer2 = new int[R*C][2];
        int[][] bufferTmp;

        int L1 = 0;
        int L2 = 0;

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (rooms[r][c] == 0) {
                    buffer1[L1][0] = r;
                    buffer1[L1][1] = c;
                    L1 ++;
                }
            }
        }
        int r, c, newD;

        while (L1 > 0){
            L2 = 0;
            for (int i = 0; i < L1; i++){
                r = buffer1[i][0];
                c = buffer1[i][1];
                newD = rooms[r][c] + 1;

                if (r - 1 >= 0 && rooms[r-1][c] > newD){
                    rooms[r-1][c] = newD;
                    buffer2[L2][0] = r-1;
                    buffer2[L2][1] = c;
                    L2 ++;
                }
                if (c - 1 >= 0 && rooms[r][c-1] > newD){
                    rooms[r][c-1] = newD;
                    buffer2[L2][0] = r;
                    buffer2[L2][1] = c-1;
                    L2 ++;
                }
                if (r + 1 < R && rooms[r+1][c] > newD){
                    rooms[r+1][c] = newD;
                    buffer2[L2][0] = r+1;
                    buffer2[L2][1] = c;
                    L2 ++;
                }
                if (c + 1 < C && rooms[r][c+1] > newD){
                    rooms[r][c+1] = newD;
                    buffer2[L2][0] = r;
                    buffer2[L2][1] = c+1;
                    L2 ++;
                }
            }
            L1 = L2;
            bufferTmp = buffer1;
            buffer1 = buffer2;
            buffer2 = bufferTmp;
        }
    }
}
