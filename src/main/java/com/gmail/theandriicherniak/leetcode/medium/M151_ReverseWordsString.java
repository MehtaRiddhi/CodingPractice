package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;

/**
 * Created by andriicherniak on 5/12/16.
 */
public class M151_ReverseWordsString {
    public String reverseWords(String s) {

        ArrayList<String> words = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                if (i > start) words.add(s.substring(start, i));
                start = i + 1;
            }
        }

        if (s.length() > start) words.add(s.substring(start, s.length()));

        StringBuilder sb = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--){
            sb.append(words.get(i));
            if (i > 0) sb.append(" ");
        }

        return sb.toString();
    }
}
