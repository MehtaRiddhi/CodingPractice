package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/17/16.
 */
public class M167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        int L = numbers.length;
        int ptr1 = 0;
        int ptr2 = L - 1;
        boolean found = false;

        while (!found && ptr1 < ptr2){
            int sum = numbers[ptr1] + numbers[ptr2];
            if (sum == target) found = true;
            else{
                if (sum > target) ptr2 --;
                else ptr1 ++;
            }
        }

        result[0] = ptr1 + 1;
        result[1] = ptr2 + 1;

        return result;
    }
}
