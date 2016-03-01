package com.gmail.theandriicherniak.leetcode.easy;


import com.gmail.theandriicherniak.leetcode.hard.H10_RegularExpressionMatching;
import com.gmail.theandriicherniak.leetcode.hard.H212_WordSearchII;
import com.gmail.theandriicherniak.leetcode.medium.M267_PalindromePermutationII;
import com.sun.jna.platform.win32.OaIdl;

import java.util.Arrays;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");

        E293_FlipGame f = new E293_FlipGame();
        f.generatePossibleNextMoves("++++");
    }
}
