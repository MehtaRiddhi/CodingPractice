package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/18/16.
 */
public class M311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int rA = A.length;
        int cA = A[0].length;

        int rB = B.length;
        int cB = B[0].length;

        int[][] C = new int[rA][cB];
        for (int rC = 0; rC < rA; rC ++){
            for (int i = 0; i < cA; i++){
                if (A[rC][i] != 0){
                    for (int c = 0; c < cB; c++){
                        C[rC][c] += A[rC][i]*B[i][c];
                    }
                }
            }
        }
        return C;
    }
}
