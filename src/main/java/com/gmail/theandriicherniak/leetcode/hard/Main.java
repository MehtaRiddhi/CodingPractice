package com.gmail.theandriicherniak.leetcode.hard;

public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H239_SlidingWindowMaximum m = new H239_SlidingWindowMaximum();
        for (int v : m.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)) System.out.println(v);
    }
}
