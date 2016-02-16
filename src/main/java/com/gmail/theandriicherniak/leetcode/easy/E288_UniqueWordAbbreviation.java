package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/16/16.
 */
import java.util.HashSet;
import java.util.HashMap;
public class E288_UniqueWordAbbreviation {
    HashMap<String, Integer> abbreviations = new HashMap<String, Integer>();
    HashSet<String> input_set = new HashSet<String>();

    private String getAbbreviation(String word){
        char[] chars = word.toCharArray();
        int L = chars.length;
        if (L <= 2) return word;

        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        sb.append(L - 2);
        sb.append(chars[L - 1]);
        return sb.toString();
    }

    public E288_UniqueWordAbbreviation(String[] dictionary) {
        for (String word : dictionary) input_set.add(word);

        for (String word : input_set) {
            String abb = getAbbreviation(word);

            if (!abbreviations.containsKey(abb)) abbreviations.put(abb, 0);
            abbreviations.put(abb, abbreviations.get(abb) + 1);
        }
    }

    public boolean isUnique(String word) {
        String abb = getAbbreviation(word);
        if (!abbreviations.containsKey(abb)) return true;
        if (abbreviations.get(abb) > 1) return false;
        if (abbreviations.get(abb) == 1 && !input_set.contains(word)) return false;
        return true;
    }
}
