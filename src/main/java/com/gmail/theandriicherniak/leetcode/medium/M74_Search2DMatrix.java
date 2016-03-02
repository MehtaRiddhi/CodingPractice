package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/2/16.
 */
public class M74_Search2DMatrix {
    private int binaryVerticalSearch(int[][] matrix, int from, int to, int target){
        System.out.println("from " + from + " " + to);

        if (target < matrix[from][0]) return -1;
        if (to - from <= 1) return from;
        if (to - from == 2) {
            if (matrix[from][0] <= target && matrix[from + 1][0] > target) return from;
            else return from + 1;
        }
        int midL = (to + from)/2;
        if (target < matrix[midL][0]) return binaryVerticalSearch(matrix, from , midL, target);
        else return binaryVerticalSearch(matrix, midL, to, target);
    }
    private int binaryHorizontalSearch(int[][] matrix, int r, int from, int to, int target){
        System.out.println("r " + r + " from " + from + " " + to);

        if (target < matrix[r][0] || target > matrix[r][to - 1]) return -1;
        if (to - from <= 1) return from;
        if (to - from == 2) {
            if (matrix[r][from] <= target && matrix[r][from + 1] > target) return from;
            else return from + 1;
        }
        int midL = (to + from)/2;
        if (target < matrix[r][midL]) return binaryHorizontalSearch(matrix, r, from, midL, target);
        else return binaryHorizontalSearch(matrix, r, midL, to, target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        if (R == 0) return false;
        int C = matrix[0].length;
        if (C == 0) return false;

        int r = binaryVerticalSearch(matrix, 0, R, target);
        if (r == -1) return false;
        int c = binaryHorizontalSearch(matrix, r, 0, C, target);
        if (c == -1) return false;

        if (matrix[r][c] == target) return true;

        return false;
    }
}
