package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");

        E325_MaximumSizeSubarraySumEqualsK model = new E325_MaximumSizeSubarraySumEqualsK();
        System.out.print(model.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));

    }
}
