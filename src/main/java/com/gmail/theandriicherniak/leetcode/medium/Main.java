package com.gmail.theandriicherniak.leetcode.medium;


import com.gmail.theandriicherniak.leetcode.easy.E293_FlipGame;
import com.gmail.theandriicherniak.leetcode.hard.H10_RegularExpressionMatching;
import com.gmail.theandriicherniak.leetcode.hard.H212_WordSearchII;
import com.gmail.theandriicherniak.leetcode.medium.M267_PalindromePermutationII;
import com.sun.jna.platform.win32.OaIdl;

import java.util.Arrays;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running");

        M240_Search2DMatrixII s = new M240_Search2DMatrixII();
        boolean r = s.searchMatrix(new int [][]{
                new int[]{1,2,3,4,5},
                new int[]{6,7,8,9,10},
                new int[]{11,12,13,14,15},
                new int[]{16,17,18,19,20},
                new int[]{21,22,23,24,25}
        }, 5);
//        boolean r = s.searchMatrix(new int[][]{
//                new int[]{1, 4, 7, 11, 15},
//                new int[]{2, 5, 8, 12, 19},
//                new int[]{3, 6, 9, 16, 22},
//                new int[]{10, 13, 14, 17, 24},
//                new int[]{18, 21, 23, 26, 30}
//        }, 22);

        System.out.println(r);


    }
}