package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/26/16.
 */
import java.util.*;

public class M131_PalindromePartitioning {

    private boolean isPalindrome(char[] data, int from, int to){
        if (to < from) return false;
        if (from == to) return true;
        while (from < to){
            if (data[from] != data[to]) return false;
            from ++;
            to --;
        }
        return true;
    }
    private void patritionDFS(char[] data, boolean[] bitmap, int from, int L, int pos, List<List<String>> result){
        boolean isPalindromePartition = isPalindrome(data, from, pos);

        if (pos == L-1 && isPalindromePartition){
            bitmap[pos] = true;

            ArrayList<String> rr = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++){
                sb.append(data[i]);
                if (bitmap[i]){
                    rr.add(sb.toString());
                    sb.setLength(0);
                }
            }
            result.add(rr);

            bitmap[pos] = false;
        }
        if (pos < L-1){
            if (isPalindromePartition) {
                bitmap[pos] = true;
                patritionDFS(data, bitmap, pos + 1, L, pos + 1, result);
                bitmap[pos] = false;
            }
            patritionDFS(data, bitmap, from, L, pos + 1, result);

        }
    }

    public List<List<String>> partition(String s) {
        char[] data = s.toCharArray();
        int L = data.length;
        List<List<String>> result = new ArrayList<List<String>>();
        boolean [] bitmap = new boolean[L];

        patritionDFS(data, bitmap, 0, L, 0, result);

        System.out.println(result);

        return result;
    }
}
