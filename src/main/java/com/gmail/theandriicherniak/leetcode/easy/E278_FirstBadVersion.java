package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 4/23/16.
 */
public class E278_FirstBadVersion {
    boolean isBadVersion(int version){
        return (version >= 10) ? true : false;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int midL;
        while (start < end){
            midL = start + (end - start) / 2;
            if (isBadVersion(midL)) end = midL;
            else start = midL + 1;
        }

        return start;
    }
}
