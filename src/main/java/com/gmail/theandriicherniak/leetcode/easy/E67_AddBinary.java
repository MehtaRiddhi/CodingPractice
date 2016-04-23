package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 4/23/16.
 */
public class E67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.equals("")) return b;
        if (b.equals("")) return a;
        int L1 = a.length();
        int L2 = b.length();
        int L = Math.max(L1, L2) + 1;
        int memory = 0;
        int v1, v2;
        int pos1 = L1-1;
        int pos2 = L2-1;
        int v;
        for (int i = 1; i <= L; i++){
            v1 = (pos1 >= 0) ? a.charAt(pos1) - '0' : 0;
            v2 = (pos2 >= 0) ? b.charAt(pos2) - '0' : 0;
            v = (v1 + v2 + memory) % 2;
            if (i <= L-1 || v == 1) sb.append(v);
            memory = (v1 + v2 + memory) / 2;
            pos1--;
            pos2--;
        }
        return sb.reverse().toString();
    }
}
