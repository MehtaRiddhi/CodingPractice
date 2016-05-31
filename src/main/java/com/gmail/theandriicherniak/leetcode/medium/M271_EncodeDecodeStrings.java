package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/31/16.
 */

import java.util.*;

public class M271_EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(":" + s.length() + ":").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int L = s.length();
        if (L == 0) return result;
        char [] ar = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int sL = 0;

        while (i < L){
            sb.setLength(0);
            sL = 0;
            i++;
            while (i < L && ar[i] != ':'){
                sL = 10 * sL + (ar[i] - '0');
                i++;
            }
            i++;
            for (int j = i; j < i + sL; j++) sb.append(ar[j]);
            i += sL;
            result.add(sb.toString());
        }
        return result;
    }
}
