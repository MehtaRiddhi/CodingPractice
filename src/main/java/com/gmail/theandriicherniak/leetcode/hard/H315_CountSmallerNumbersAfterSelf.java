package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/6/16.
 */
import java.util.*;

public class H315_CountSmallerNumbersAfterSelf {
    private void addV(int [] tree, int treeL, int id){

        while (id < treeL){
            tree[id] ++;
            id += id & (-id);
        }
    }
    private int getV(int [] tree, int treeL, int id){
        int counter = 0;

        while (id >= 1){
            counter += tree[id];
            id -= id & (-id);
        }

        return counter;
    }
    public List<Integer> countSmaller(int[] nums) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int L = nums.length;
        if (L == 0) return result;
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;

        int [] buffer = new int[L];

        for (int i = 0; i < L; i++){
            minV = Math.min(minV, nums[i]);
            maxV = Math.max(maxV, nums[i]);
        }

        int newL = maxV - minV + 1;

        int[] tree = new int[newL + 1];
        int v;

        for (int i = L - 1; i >= 0; i--){
            v = nums[i] - minV + 1;
            addV(tree, newL, v);
            buffer[i] = getV(tree, newL, v - 1);
        }

        for (int i = 0; i < L; i++) result.add(buffer[i]);

        return result;
    }
}
