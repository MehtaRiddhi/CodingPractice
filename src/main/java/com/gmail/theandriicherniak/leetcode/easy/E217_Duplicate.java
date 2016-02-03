package com.gmail.theandriicherniak.leetcode.easy;
import java.util.HashSet;

/**
 * Created by andriicherniak on 2/2/16.
 */
public class E217_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) set.add(i);
        if (set.size() < nums.length) return true;
        return false;
    }
}
