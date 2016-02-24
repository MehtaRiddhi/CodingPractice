package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/24/16.
 */
import java.util.*;

public class M320_GeneralizedAbbreviation {
    private String bitmapToAbbrreviation(char[] data, int dataL, boolean[] bitmap){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < dataL; i++) {
            if (bitmap[i]) cnt ++;
            if (!bitmap[i]) {
                if (cnt > 0) sb.append(cnt);
                cnt = 0;
                sb.append(data[i]);
            }
        }
        if (cnt > 0) sb.append(cnt);
        return sb.toString();
    }
    private void abbreviatonHelper(char[] data, int dataL, int prefixL, int targetL, int startPosition, boolean[] bitmap, ArrayList<String> result){
        if (prefixL == targetL) result.add(bitmapToAbbrreviation(data, dataL, bitmap));
        else {
            for (int i = startPosition; i < dataL; i++){
                bitmap[i] = true;
                abbreviatonHelper(data, dataL, prefixL + 1, targetL, i+1, bitmap, result);
                bitmap[i] = false;
            }
        }
    }

    public List<String> generateAbbreviations(String word) {
        ArrayList<String> result = new ArrayList<String>();
        char [] data = word.toCharArray();
        int L = data.length;

        boolean [] bitmap = new boolean[L];
        result.add(word);

        for (int l = 1; l <= L; l++){
            for (int j = 0; j < L; j++) bitmap[j] = false;
            abbreviatonHelper(data, L, 0, l, 0, bitmap, result);
        }

        System.out.println(result);

        return result;
    }
}
