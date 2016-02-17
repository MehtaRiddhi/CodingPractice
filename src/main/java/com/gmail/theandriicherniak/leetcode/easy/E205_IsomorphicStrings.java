package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/17/16.
 */
import java.util.HashMap;

public class E205_IsomorphicStrings {
    private int[] signature(char[] ar, int L){
        HashMap<Character, Integer> char_map = new HashMap<Character, Integer>();
        int char_index = 0;
        int [] result = new int[L];
        for (int i = 0; i < L; i++){
            if (!char_map.containsKey(ar[i])) {
                char_map.put(ar[i], char_index);
                char_index ++;
            }
            result[i] = char_map.get(ar[i]);
        }
        return result;
    }

    public boolean isIsomorphic(String s, String t) {
        char[] s_ar = s.toCharArray();
        char[] t_ar = t.toCharArray();

        int L1 = s_ar.length;
        int L2 = t_ar.length;

        if (L1 != L2) return false;
        int [] s_signature = signature(s_ar, L1);
        int [] t_signature = signature(t_ar, L2);

        boolean result = true;
        int id = 0;
        while (result && (id < L1)){
            if (s_signature[id] != t_signature[id]) result = false;
            id ++;
        }

        return result;
    }
}
