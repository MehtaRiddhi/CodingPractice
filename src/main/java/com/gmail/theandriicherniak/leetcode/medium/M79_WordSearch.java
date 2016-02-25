package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/25/16.
 */
public class M79_WordSearch {
    private boolean searchHelper(char[][] board, boolean[][] bitmap, int r, int c, int R, int C, char[] prefix, int prefixL, char[] target, int targetL){
        if (r < 0 || r >= R || c < 0 || c >= C) return false;
        if (bitmap[r][c]) return false;
        prefix[prefixL] = board[r][c];

        for (int i = 0; i <= prefixL; i++){
            if (prefix[i] != target[i]) return false;
        }

        if (prefixL + 1 == targetL) return true;

        bitmap[r][c] = true;

        if (searchHelper(board, bitmap, r - 1, c, R, C, prefix, prefixL + 1, target, targetL)) return true;
        if (searchHelper(board, bitmap, r + 1, c, R, C, prefix, prefixL + 1, target, targetL)) return true;
        if (searchHelper(board, bitmap, r, c - 1, R, C, prefix, prefixL + 1, target, targetL)) return true;
        if (searchHelper(board, bitmap, r, c + 1, R, C, prefix, prefixL + 1, target, targetL)) return true;

        bitmap[r][c] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.equals("")) return true;

        int R = board.length;
        if (R == 0) return false;
        int C = board[0].length;

        boolean[][] bitmap = new boolean[R][C];
        char[] data = word.toCharArray();
        char[] buffer = new char[data.length];

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (searchHelper(board, bitmap, r, c, R, C, buffer, 0, data, data.length)) return true;
            }
        }

        return false;
    }
}
