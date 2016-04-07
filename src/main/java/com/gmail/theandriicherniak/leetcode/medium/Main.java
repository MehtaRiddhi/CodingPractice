package com.gmail.theandriicherniak.leetcode.medium;


/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M121_BestTimeBuySellStock stock = new M121_BestTimeBuySellStock();

        int[] data = new int[10000];
        for (int i = 0; i < 10000; i++) data[i] = 10000 - i;
        System.out.println(stock.maxProfit(data));


    }
}