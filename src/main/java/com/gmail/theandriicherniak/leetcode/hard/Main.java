package com.gmail.theandriicherniak.leetcode.hard;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by andriicherniak on 3/16/16.
 */
public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H4_MedianTwoSortedArrays m = new H4_MedianTwoSortedArrays();
        Random rnd = new Random();
        int L1 = 40;
        int L2 = 37;
        int L3 = L1 + L2;
        int [] a1 = new int[L1];
        int [] a2 = new int[L2];


        for (int i = 0; i < L1; i++) a1[i] = (int) Math.round(100 * rnd.nextDouble());
        for (int i = 0; i < L2; i++) a2[i] = (int) Math.round(100 * rnd.nextDouble());

        Arrays.sort(a1);
        Arrays.sort(a2);

        int [] a3 = new int[L3];
        for (int i = 0; i < L1; i++) a3[i] = a1[i];
        for (int i = L1; i < L3; i ++) a3[i] = a2[i - L1];

        Arrays.sort(a3);

        int medId2 = L3 / 2;
        int medId1 = (L3 % 2 == 1) ? L3 / 2 : (L3 / 2 - 1);

//        for (int i = 0; i < L1; i ++) System.out.print(a1[i] + " ");
//        System.out.println();
//
//        for (int i = 0; i < L2; i ++) System.out.print(a2[i] + " ");
//        System.out.println();
//
//        for (int i = 0; i < L3; i ++) System.out.print(a3[i] + " ");
//        System.out.println();

        System.out.println(a3[medId1] + " " + a3[medId2] + " real median : " + 0.5 * (a3[medId1] + a3[medId2]));

        System.out.println(m.findMedianSortedArrays(a1, a2));
    }
}
