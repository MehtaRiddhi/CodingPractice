package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/26/16.
 */

import java.util.*;

public class M93_RestoreIPAddresses {
    private int getNumber(int[] digits, int from, int to) {
        int number = 0;
        for (int i = from; i < to; i++) {
            number *= 10;
            number += digits[i];
        }

        return number;
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        char[] digits_ch = s.toCharArray();
        int L = digits_ch.length;

        if (L > 12) return result;

        int[] digits = new int[L];

        for (int i = 0; i < L; i++) digits[i] = Integer.parseInt("" + digits_ch[i]);

        for (int a = 1; a <= 4; a++){
            for (int b = 1; b <= Math.min(4, L - a); b++){
                for (int c = 1; c <= Math.min(4, L - a - b); c++){
                    for (int d = 1; d <= Math.min(4, L - a - b - c); d++){
                        if (a + b + c + d == L){
                            int na = getNumber(digits, 0, a);
                            int nb = getNumber(digits, a, a+b);
                            int nc = getNumber(digits, a+b, a+b+c);
                            int nd = getNumber(digits, a+b+c, L);

                            if (na > 255) continue;
                            if (nb > 255) continue;
                            if (nc > 255) continue;
                            if (nd > 255) continue;

                            if (a > 1 && digits[0] == 0) continue;
                            if (b > 1 && digits[a] == 0) continue;
                            if (c > 1 && digits[a+b] == 0) continue;
                            if (d > 1 && digits[a+b+c] == 0) continue;

                            result.add(na + "." + nb + "." + nc + "." + nd);

                        }
                    }
                }
            }
        }

        return result;
    }
}
