package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 3/16/16.
 */
public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H315_CountSmallerNumbersAfterSelf cc = new H315_CountSmallerNumbersAfterSelf();
        int [] data = new int[]{5, 2, 6, 1};
        System.out.println(cc.countSmaller(data));

    }
}
