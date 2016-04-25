package com.gmail.theandriicherniak.leetcode.hard;

import java.util.List;

public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H218_TheSkylineProblem skyline = new H218_TheSkylineProblem();
        List<int[]> result =  skyline.getSkyline(new int[][]{
                new int[]{2,9,10},
                new int[]{3,7,15},
                new int[]{5,12,12},
                new int[]{15,20,10},
                new int[]{19,24,8}

        });
        for (int [] pp : result){
            System.out.println(pp[0] + " " + pp[1]);
        }

    }
}
