package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/18/16.
 */
import java.util.*;

public class M187_RepeatedDNASequences {
    private int charCode(char ch){
        int code;
        switch (ch){
            case 'A' : code = 0; break;
            case 'C' : code = 1; break;
            case 'G' : code = 2; break;
            case 'T' : code = 3; break;
            default: code = 0; break;
        }

        return code;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        char [] data = s.toCharArray();
        List<String> result = new ArrayList<String>();
        HashSet<String> result_set = new HashSet<String>();
        int L = data.length;
        if (L <= 10) return result;

        int bitMask = 0;
        for (int i = 1; i <= 30; i++) {
            bitMask <<= 1;
            bitMask += 1;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        int key = 0;
        for (int i = 0; i <= 9; i++){
            key <<= 3;
            key += charCode(data[i]);
        }

        set.add(key);
        StringBuilder sb = new StringBuilder();

        for (int i = 10; i < L; i++){
            key <<= 3;
            key += charCode(data[i]);

            key &= bitMask;
            if (set.contains(key)) {
                sb.setLength(0);
                for (int j = i - 9; j <= i; j++)sb.append(data[j]);
                result_set.add(sb.toString());
            }
            set.add(key);
        }

        for (String ss : result_set) result.add(ss);
        return result;
    }
}
