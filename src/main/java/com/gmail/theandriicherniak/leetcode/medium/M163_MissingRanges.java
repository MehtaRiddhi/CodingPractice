package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/19/16.
 */
import java.util.*;

public class M163_MissingRanges {
    private int ceil(int [] nums, int from, int to, int v){
        if (v <= nums[from]) return from;
        if (v > nums[to]) return -1;

        if (to - from <= 1) {
            for (int i = to; i >= from; i--){
                if (nums[i] == v) return i;
                if (nums[i] >= v && nums[i-1] < v) return i;
            }
        }
        int midL = (from + to) / 2;
        if (nums[midL] <= v) return ceil(nums, midL, to, v);
        else return ceil(nums, from, midL, v);
    }

    private int floor(int [] nums, int from, int to, int v){
        if (v < nums[from]) return -1;
        if (v >= nums[to]) return to;

        if (to - from <= 1) {
            for (int i = to; i >= from; i--){
                if (nums[i] <= v) return i;
            }
        }
        int midL = (from + to) / 2;
        if (nums[midL] <= v) return floor(nums, midL, to, v);
        else return floor(nums, from, midL, v);
    }

    private String generateInterval(int from, int to){
        if (to - from < 0) return "";
        else if (to - from == 0) return ""+ from;
        else return from + "->" + to;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int L = nums.length;

        if (L == 0) {
            result.add(generateInterval(lower, upper));
            return result;
        }
        if (lower > nums[L-1] || upper < nums[0]){
            result.add(generateInterval(lower, upper));
            return result;
        }

        int c = ceil(nums, 0, L-1, lower);
        int f = floor(nums, 0, L-1, upper);

        String intervalStr = generateInterval(lower, nums[c] - 1);
        if (!intervalStr.equals("")) result.add(intervalStr);

        for (int i = c; i < f; i++){
            intervalStr = generateInterval(nums[i] + 1, nums[i+1] - 1);
            if (!intervalStr.equals("")) result.add(intervalStr);
        }

        intervalStr = generateInterval(nums[f] + 1, upper);
        if (!intervalStr.equals("")) result.add(intervalStr);

        return result;
    }
}
