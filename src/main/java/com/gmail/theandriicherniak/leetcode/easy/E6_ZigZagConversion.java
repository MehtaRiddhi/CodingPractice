package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/14/16.
 */
public class E6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] s_ar = s.toCharArray();
        int L = s_ar.length;
        if (L <= numRows) return s;

        StringBuffer sb = new StringBuffer();
        int period = 2*numRows - 2;
        int ptr1, ptr2;

        for (int row = 1; row <= numRows; row++) {
            ptr1 = row - 1;
            ptr2 = numRows + (numRows - row - 1);

            while (ptr1 < L) {
                sb.append(s_ar[ptr1]);
                if (row >= 2 && row <= (numRows - 1) && ptr2 < L){
                    sb.append(s_ar[ptr2]);
                }
                ptr1 += period;
                ptr2 += period;
            }
        }

        return sb.toString();
    }
}
