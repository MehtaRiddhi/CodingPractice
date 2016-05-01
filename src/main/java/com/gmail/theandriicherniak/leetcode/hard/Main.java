package com.gmail.theandriicherniak.leetcode.hard;

import java.util.*;

public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running hard examples");


        int[][] data = new int[][]{
                new int[]{3, 0, 1, 4, 2},
                new int[]{5, 6, 3, 2, 1},
                new int[]{1, 2, 0, 1, 5},
                new int[]{4, 1, 0, 1, 7},
                new int[]{1, 0, 3, 0, 5}
        };

        H308_RangeSumQuery2D rsq = new H308_RangeSumQuery2D(data);

        System.out.println(rsq.sumRegion(2,1,4,3));
        rsq.update(3,2,2);
        System.out.println(rsq.sumRegion(2,1,4,3));


//        int v = 10;
//        System.out.println(Integer.toBinaryString(v));
//        v += v & (-v);
//        System.out.println(Integer.toBinaryString(v));
//        v += v & (-v);
//        System.out.println(Integer.toBinaryString(v));
//        v += v & (-v);
//        System.out.println(Integer.toBinaryString(v));












    }
}
