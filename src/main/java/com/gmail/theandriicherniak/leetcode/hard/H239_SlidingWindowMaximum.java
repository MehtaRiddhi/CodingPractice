package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/22/16.
 */
import java.util.*;

public class H239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int L = nums.length;
        if (L < k || k <= 0) return new int[0];
        int [] result = new int [L-k+1];

        int maxVal = nums[0];
        int maxId = -1;

        int begin = 0;
        int end = k -1;
        while (end < L){
            if (maxId < begin){
                maxId = begin;
                maxVal = nums[begin];
                for (int i = begin + 1; i <= end; i++){
                    if (nums[i] > maxVal){
                        maxId = i;
                        maxVal = nums[i];
                    }
                }
            }else {
                if (nums[end] > maxVal){
                    maxId = end;
                    maxVal = nums[end];
                }
            }
            result[begin] = maxVal;
            begin ++;
            end ++;
        }

        return result;
    }
}
