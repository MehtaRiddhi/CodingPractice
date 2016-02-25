package com.gmail.theandriicherniak.leetcode.hard;


/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");

        H212_WordSearchII ws = new H212_WordSearchII();
        String[] words = new String [] {
                "ba", "ab"
        };
        char[][] board = new char[][]{
                "ab".toCharArray(),
                "ba".toCharArray()
        };
        ws.findWords(board, words);

    }
}
