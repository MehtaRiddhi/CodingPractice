package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/4/16.
 */
import java.util.HashMap;
public class E219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
        int val = 0;
        int i = 0;
        while ( i < nums.length && !result){
            val = nums[i];
            if (positions.containsKey(val) && (i - positions.get(val) <= k)) result = true;
            positions.put(val, i);
            i++;
        }
        return result;
    }
}
