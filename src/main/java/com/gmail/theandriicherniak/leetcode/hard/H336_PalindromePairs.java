package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/21/16.
 */

import java.util.*;

public class H336_PalindromePairs {
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int L = words.length;
        if (L == 0) return result;

        HashMap<String, Integer> buffer = new HashMap<String, Integer>();

        for (int i = 0; i < L; i++) {
            buffer.put(words[i], i);
        }

        if (buffer.containsKey("")){
            int id1 = buffer.get("");
            for (int i = 0; i < L; i++) {
                if (i != id1 && isPalindrome(words[i])){
                    result.add(Arrays.asList(id1, i));
                    result.add(Arrays.asList(i, id1));
                }
            }
        }

        for (int i = 0; i < L; i++){
            String wRev = reverse(words[i]);

            if (buffer.containsKey(wRev)){
                int idRev = buffer.get(wRev);
                if (i != idRev) {
                    result.add(Arrays.asList(i, idRev));
                }
            }
        }

        for (int i = 0; i < L; i++){
            String word = words[i];
            int wL = word.length();

            for (int id = 1; id < wL; id++) {
                String w1 = reverse(word.substring(id));
                if (buffer.containsKey(w1) && isPalindrome(word.substring(0, id))){
                    result.add(Arrays.asList(buffer.get(w1), i));
                }
            }

            word = reverse(words[i]);

            for (int id = 1; id < wL; id++) {
                String w1 = word.substring(id);
                if (buffer.containsKey(w1) && isPalindrome(word.substring(0, id))){
                    result.add(Arrays.asList(i, buffer.get(w1)));
                }
            }
        }

        return result;
    }
}
