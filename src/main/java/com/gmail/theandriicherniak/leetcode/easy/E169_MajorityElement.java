package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/31/16.
 */
public class E169_MajorityElement {
    public int majorityElement(int[] nums) {
        // Majority Vote
        int counter = 0;
        int candidate = 0;
        for (int e : nums){
            if (counter == 0){
                counter ++;
                candidate = e;
            }else{
                if (e == candidate) counter ++;
                else counter --;
            }
        }

        return candidate;
    }
}
