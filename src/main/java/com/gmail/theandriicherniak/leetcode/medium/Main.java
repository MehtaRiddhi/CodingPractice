package com.gmail.theandriicherniak.leetcode.medium;


/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M307_RangeSumQuery rsq = new M307_RangeSumQuery(new int[]{1, 3, 5});
        System.out.println(rsq.sumRange(0, 2));
        rsq.update(1, 2);
        System.out.println(rsq.sumRange(0, 2));

    }
}