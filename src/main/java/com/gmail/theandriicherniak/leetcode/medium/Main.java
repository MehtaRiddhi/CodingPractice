package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M289_GameOfLife life = new M289_GameOfLife();
        int [][] board = new int[][]{
                new int[]{0,0,0,0,0,0},
                new int[]{0,0,1,1,0,0},
                new int[]{0,1,0,0,1,0},
                new int[]{0,0,1,1,0,0},
                new int[]{0,0,0,0,0,0}
        };
        life.gameOfLife(board);

    }
}