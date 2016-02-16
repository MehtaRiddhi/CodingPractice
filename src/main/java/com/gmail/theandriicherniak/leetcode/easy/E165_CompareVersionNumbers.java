package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/16/16.
 */
public class E165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1_s = version1.split("\\.");
        String[] v2_s = version2.split("\\.");

        int L1 = v1_s.length;
        int L2 = v2_s.length;

        int v1, v2;

        int i = 0;

        while (i < Math.min(L1, L2)){
            v1 = Integer.parseInt(v1_s[i]);
            v2 = Integer.parseInt(v2_s[i]);
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
            i++;
        }

        if (L1 == L2) return 0;

        int comparison_sign = 0;
        String [] longer_v;

        if (L1 > L2){
            longer_v = v1_s;
            comparison_sign = 1;
        }else {
            longer_v = v2_s;
            comparison_sign = -1;
        }


        while (i < Math.max(L1, L2)){
            if (Integer.parseInt(longer_v[i]) > 0) return comparison_sign;
            i++;
        }

        return 0;
    }
}
