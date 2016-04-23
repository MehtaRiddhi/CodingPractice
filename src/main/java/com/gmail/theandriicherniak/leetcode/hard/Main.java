package com.gmail.theandriicherniak.leetcode.hard;

public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");
        H295_FindMedianDataStream m = new H295_FindMedianDataStream();
        m.addNum(2);
        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(4);
        System.out.println(m.findMedian());

    }
}
