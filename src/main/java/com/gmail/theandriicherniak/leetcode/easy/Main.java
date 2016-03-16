package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/16/16.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("runing easy ");

        E1_TwoSum s = new E1_TwoSum();
        int [] result = s.twoSum(new int[]{3,2,4}, 6);
        System.out.println(result[0] + " " + result[1]);
    }
}
