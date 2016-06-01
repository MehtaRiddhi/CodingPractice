package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 5/31/16.
 */
public class H32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int L = s.length();
        if (L == 0) return 0;
        char[] ar = s.toCharArray();

        int maxL = 0;
        int left = 0;

        int [] result = new int[L + 1];
        int [] start = new int[L + 1];

        for (int i = 0; i < L; i++){
            if (ar[i] == '('){
                start[++left] = i;
            }else {
                if (left > 0){
                    result[i] = result[i - 1] + 2;
                    if (start[left] > 0) result[i] += result[start[left] - 1];
                    maxL = Math.max(maxL, result[i]);
                    left --;
                }else {
                    result[i] = 0;
                }
            }
        }

        return maxL;
    }
}
