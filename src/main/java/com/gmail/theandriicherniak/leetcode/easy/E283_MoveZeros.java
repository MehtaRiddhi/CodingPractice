package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/11/16.
 */
public class E283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int L = nums.length;
        int ptr = 0;
        int buff = 0;
        for (int i = 0; i < L; i++){
            buff = nums[i];
            if (buff != 0){
                nums[ptr] = buff;
                ptr ++;
            }
        }

        for (int i = ptr; i < L; i++) nums[i] = 0;
    }
}
