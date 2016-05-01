package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/1/16.
 */
/*
0 - dead
1 - live
2 - dead to live
3 - live to dead
 */

public class M289_GameOfLife {
    private int neighboursCount(int[][] board, int r, int c, int R, int C){
        int cnt = 0;
        int fromR = Math.max(0, r - 1);
        int toR = Math.min(r + 1, R - 1);
        int fromC = Math.max(0, c - 1);
        int toC = Math.min(c + 1, C - 1);

//        System.out.println("r c from R toR fromC toC " + r + " " + c + " " + fromR + " " + toR + " " + fromC + " " + toC);

        for (int i = fromR; i <= toR; i++){
            for (int j = fromC; j <= toC; j++){
                if (i != r || j != c) {
                    if (board[i][j] == 1 || board[i][j] == 3) cnt ++;
                }
            }
        }
//        System.out.println(cnt);

        return cnt;
    }
    public void gameOfLife(int[][] board) {
        int R = board.length;
        if (R == 0) return;
        int C = board[0].length;
        if (C == 0) return;

        int liveNeighbours;

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                liveNeighbours = neighboursCount(board, r, c, R, C );
                if (board[r][c] == 1){
                    if (liveNeighbours < 2 || liveNeighbours > 3) board[r][c] = 3;
                }
                if (board[r][c] == 0){
                    if (liveNeighbours == 3) board[r][c] = 2;
                }
            }
        }

        for (int r = 0; r < R; r ++){
            for (int c = 0; c < C; c++){
                if (board[r][c] == 3) board[r][c] = 0;
                else if (board[r][c] == 2) board[r][c] = 1;
            }
        }
    }
}
