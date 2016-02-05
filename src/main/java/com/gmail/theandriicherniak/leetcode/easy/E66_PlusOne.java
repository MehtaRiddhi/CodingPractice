package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/4/16.
 */
public class E66_PlusOne {
    public int[] plusOne(int[] digits) {
        int shift = 1;
        int l = digits.length;
        int digit = 0;
        for (int i = l-1; i >= 0; i--){
            digit = digits[i] + shift;
            if (digit <= 9) {
                shift = 0;
                digits[i] = digit;
            }
            else {
                shift = 1;
                digits[i] = 0;
            }
        }
        if (shift == 0) return digits;
        else{
            int [] new_digits = new int[l+1];
            new_digits[0] = 1;
            for (int i = 1; i <= l; i++) new_digits[i] = digits[i-1];
            return new_digits;
        }
    }
}
