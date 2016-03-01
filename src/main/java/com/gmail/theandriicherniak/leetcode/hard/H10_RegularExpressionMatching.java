package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 2/29/16.
 */
public class H10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] s_data = s.toCharArray();
        char[] p_data = p.toCharArray();
        int L_s = s_data.length;
        int L_p = p_data.length;

        if (L_p == 0 || L_s == 0) return false;

        boolean exactMatch = true;
        boolean matched = true;

        if (L_p != L_s){
            int i = 0;
            while (i < L_p && exactMatch){
                if (p_data[i] == '*') exactMatch = false;
                i++;
            }
            i = 0;
            while (i < L_s && exactMatch){
                if (s_data[i] == '*') exactMatch = false;
                i++;
            }

            if (exactMatch) return false;
        }

        if (L_p == L_s){
            int i = 0;
            while (i < L_p && matched && exactMatch){
                if (s_data[i] == '*' || p_data[i] == '*') exactMatch = false;
                if (s_data[i] != p_data[i] && !(s_data[i] == '.' || p_data[i] == '.')) matched = false;
                i++;
            }
        }
        if (exactMatch && !matched) return false;
        if (!exactMatch){

        }
        return true;
    }
}
