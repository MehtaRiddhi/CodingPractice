package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 3/1/16.
 */
import java.util.*;

public class E293_FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        char [] data = s.toCharArray();
        int L = data.length;
        if (L == 0) return result;

        StringBuilder sb = new StringBuilder();

        for (int pos = 0; pos < L - 1; pos++){
            if (data[pos] == '+' && data[pos + 1] == '+'){
                sb.setLength(0);
                data[pos] = '-';
                data[pos + 1] = '-';

                for (int j = 0; j < L; j++) sb.append(data[j]);
                result.add(sb.toString());

                data[pos] = '+';
                data[pos + 1] = '+';
            }
        }

        System.out.println(result);

        return result;
    }
}
