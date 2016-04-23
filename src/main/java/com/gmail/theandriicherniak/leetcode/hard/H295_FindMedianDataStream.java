package com.gmail.theandriicherniak.leetcode.hard;

import java.util.*;

/**
 * Created by andriicherniak on 4/22/16.
 */
public class H295_FindMedianDataStream {

    ArrayList<Integer> list = new ArrayList<Integer>();
    int L = 0;

    // Adds a number into the data structure.
    public void addNum(int num) {
        int left = 0;
        int right = L - 1;
        int midL;
        while (left <= right){
            midL = (left + right) / 2;
            if (num > list.get(midL)) left = midL + 1;
            else right = midL - 1;
        }
        list.add(left, num);
        L++;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (L == 0) return 0;
        else if (L % 2 == 0) return 0.5*(list.get(L/2) + list.get(L/2 - 1));
        else return list.get(L/2);
    }
}
