package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/29/16.
 */
import java.util.*;

public class M54_SpiralMatrix {
    private void printCircle(int[][] matrix, int fromR, int toR, int fromC, int toC, List<Integer> result){
        if (fromR == toR){
            for (int c = fromC; c <= toC; c ++) result.add(matrix[fromR][c]);
        }else if (fromC == toC){
            for (int r = fromR; r <= toR; r++) result.add(matrix[r][fromC]);
        }else {
            for (int c = fromC; c <= toC; c++) result.add(matrix[fromR][c]);
            for (int r = fromR + 1; r <= toR; r++) result.add(matrix[r][toC]);
            for (int c = toC - 1; c >= fromC; c--) result.add(matrix[toR][c]);
            for (int r = toR - 1; r >= fromR + 1; r--) result.add(matrix[r][fromC]);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int R = matrix.length;
        if (R == 0) return result;
        int C = matrix[0].length;
        if (C == 0) return result;

        int fromR = 0;
        int toR = R - 1;
        int fromC = 0;
        int toC = C - 1;

        while (fromR <= toR && fromC <= toC) {
            printCircle(matrix, fromR, toR, fromC, toC, result);
            fromR ++;
            toR --;
            fromC ++;
            toC --;
        }

        return result;
    }
}
