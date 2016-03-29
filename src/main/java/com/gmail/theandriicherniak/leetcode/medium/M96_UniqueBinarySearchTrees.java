package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/29/16.
 */
public class M96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int [] memory = new int[n + 1];
        memory[0] = 1;
        memory[1] = 1;
        for (int i = 2; i <= n; i++){
            int counter = 0;
            for (int j = 1; j <= i; j++){
                int leftTreeElements = j - 1;
                int rightTreeElements = i - j;
                counter += memory[leftTreeElements] * memory[rightTreeElements];
            }
            memory[i] = counter;
        }

        return memory[n];
    }
}
