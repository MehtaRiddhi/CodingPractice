package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/2/16.
 */
public class M240_Search2DMatrixII {
    private boolean binarySearch(int[][] matrix, int target, int from_r, int to_r, int from_c, int to_c) {
        System.out.println("from_r " + from_r + " to_r " + to_r + " from_c " + from_c + " to_c " + to_c);

        if (to_r - from_r <= 1 && to_c - from_c <= 1) {

            boolean found = false;
            for (int r = from_r; r <= to_r; r++) {
                for (int c = from_c; c <= to_c; c++) {
                    if (matrix[r][c] == target) found = true;
                }
            }
            return found;
        }

        if (target < matrix[from_r][from_c] || target > matrix[to_r][to_c]) return false;
        int midR = (from_r + to_r) / 2;
        int midC = (from_c + to_c) / 2;

        System.out.println("midV " + matrix[midR][midC]);

        if (target >= matrix[from_r][from_c] && target <= matrix[midR][midC]) {
            if (binarySearch(matrix, target, from_r, midR, from_c, midC)) return true;
        }
        if (target >= matrix[from_r][midC] && target <= matrix[midR][to_c]) {
            if (binarySearch(matrix, target, from_r, midR, midC, to_c)) return true;
        }
        if (
                target >= matrix[midR][from_c] && target <= matrix[to_r][midC]) {
            if (binarySearch(matrix, target, midR, to_r, from_c, midC)) return true;
        }
        if (
                target >= matrix[midR][midC] &&
                        target <= matrix[to_r][to_c]) {
            if (binarySearch(matrix, target, midR, to_r, midC, to_c)) return true;
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        if (R == 0) return false;
        int C = matrix[0].length;
        if (C == 0) return false;

        return binarySearch(matrix, target, 0, R - 1, 0, C - 1);

    }
}
