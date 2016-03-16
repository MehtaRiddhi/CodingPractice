package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/16/16.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class E1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int L = nums.length;
        int [] result = new int[]{0, 0};
        HashMap<Integer, ArrayList<Integer>> numPosition = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> numCnt = new HashMap<Integer, Integer>();


        for (int i = 0; i < L; i ++){
            int key = nums[i];
            if (!numPosition.containsKey(key)) {
                numPosition.put(key, new ArrayList<Integer>());
                numCnt.put(key, 0);
            }
            numPosition.get(key).add(i);
            numCnt.put(key, numCnt.get(key) + 1);
        }
        for (int i = 0; i < L; i++){
            int key = nums[i];
            int residual = target - key;

            if (key == residual){
                if (numCnt.containsKey(key) && numCnt.get(key) > 1){
                    result[0] = numPosition.get(key).get(0);
                    result[1] = numPosition.get(key).get(1);
                    return result;
                }
            }else {
                if (numCnt.containsKey(residual)){
                    result[0] = numPosition.get(key).get(0);
                    result[1] = numPosition.get(residual).get(0);
                    return result;
                }
            }

        }
        return result;
    }
}
