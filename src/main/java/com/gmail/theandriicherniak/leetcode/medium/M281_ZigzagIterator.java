package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/18/16.
 */

import java.util.*;

public class M281_ZigzagIterator {
    private List<Integer> v1;
    private List<Integer> v2;
    private int v1L;
    private int v2L;
    private int v1Ptr;
    private int v2Ptr;
    private int flipFlop;

    public M281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        v1L = v1.size();
        v2L = v2.size();
        v1Ptr = 0;
        v2Ptr = 0;
        flipFlop = 0;
    }

    public int next() {
        if (flipFlop == 0 && v1Ptr < v1L){
            flipFlop = 1;
            v1Ptr ++;
            return v1.get(v1Ptr - 1);
        }else if (flipFlop == 1 && v2Ptr < v2L){
            flipFlop = 0;
            v2Ptr ++;
            return v2.get(v2Ptr - 1);
        }else {
            if (v1Ptr < v1L){
                v1Ptr ++;
                return v1.get(v1Ptr - 1);
            }else {
                v2Ptr ++;
                return v2.get(v2Ptr - 1);
            }
        }
    }

    public boolean hasNext() {
        return v1Ptr < v1L || v2Ptr < v2L;
    }
}
