package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/25/16.
 */
import java.util.*;

public class M39_CombinationSum {
    public void DFSsum(int[] candidates, int L, int target, int [] buffer, int bufferL, int maxBufferL, int curSum, int minPos, List<List<Integer>> result){
        if (curSum == target){
            ArrayList<Integer> s = new ArrayList<Integer>();
            for (int i = 0; i < bufferL; i++) s.add(buffer[i]);
            result.add(s);
        }

        if (curSum < target && bufferL < maxBufferL){
            for (int i = minPos; i < L; i++){
                buffer[bufferL] = candidates[i];

                if (target - curSum >= candidates[i])
                    DFSsum(candidates, L, target, buffer, bufferL + 1, maxBufferL, curSum + buffer[bufferL], i, result);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        int maxBufferL = target / candidates[0] + 1;
        int [] buffer = new int[maxBufferL];

        int L = candidates.length;
        if (L == 0) return result;

        DFSsum(candidates, L, target, buffer, 0, maxBufferL, 0, 0, result);

        System.out.println(result);

        return result;
    }
}
