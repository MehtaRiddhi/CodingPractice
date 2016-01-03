package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 1/3/16.
 */
public class E242_ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        boolean is_anagram = true;

        int l = 'z' - 'a' + 1;
        int [] sa = new int[l];
        int [] ta = new int[l];

        for (char ch : s.toCharArray()){
            sa[ch - 'a'] ++;
        }

        for (char ch : t.toCharArray()){
            ta[ch - 'a'] ++;
        }

        for (int i = 0; i < l; i++){
            if (sa[i] != ta[i]) is_anagram = false;
        }

        return is_anagram;
    }
}
