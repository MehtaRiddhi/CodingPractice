package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/25/16.
 */
import java.util.*;

public class M77_Combinations {
    private void helper(int minVal, int n, int curK, int k, int[] buffer, List<List<Integer>> result){
        if (curK == k){
            ArrayList<Integer> rr = new ArrayList<Integer>();
            for (int i = 0; i < curK; i++) rr.add(buffer[i]);
            result.add(rr);
        }
        if (curK < k){
            for (int i = minVal; i <= n; i++){
                buffer[curK] = i;
                helper(i+1, n, curK + 1, k, buffer, result);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0) return result;
        if (n < k) return result;

        int[] buffer = new int[k];

        helper(1, n, 0, k, buffer, result);

        System.out.println(result);

        return result;
    }
}
