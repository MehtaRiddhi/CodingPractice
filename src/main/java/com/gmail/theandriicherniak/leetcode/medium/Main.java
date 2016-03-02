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

        M74_Search2DMatrix s = new M74_Search2DMatrix();
        boolean r = s.searchMatrix(new int[][]{
                new int[]{1},
                new int[]{3},
        }, 3);

        System.out.println(r);

    }
}