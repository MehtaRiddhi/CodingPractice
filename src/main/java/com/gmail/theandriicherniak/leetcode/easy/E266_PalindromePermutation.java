package com.gmail.theandriicherniak.leetcode.easy;

import java.util.HashMap;
/**
 * Created by andriicherniak on 2/10/16.
 */
public class E266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

        for (char ch : s.toCharArray()){
            if (!counter.containsKey(ch)) counter.put(ch, 0);
            counter.put(ch, counter.get(ch) + 1);
        }

        int odd_counter = 0;

        for (int vv : counter.values()){
            if (vv % 2 == 1) odd_counter ++;
        }


        if (odd_counter > 1) return false;
        return true;
    }
}
