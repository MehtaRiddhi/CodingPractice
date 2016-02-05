package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/4/16.
 */
public class E27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int pos = -1;
        int tmp  = 0;
        for (int i = 0; i < nums.length; i++){
            tmp = nums[i];
            if (tmp != val){
                nums[++pos] = tmp;
            }
        }
        return (pos + 1);
    }
}
