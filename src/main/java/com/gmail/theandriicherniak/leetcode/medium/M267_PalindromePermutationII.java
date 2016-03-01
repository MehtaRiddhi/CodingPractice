package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/29/16.
 */
import java.util.*;

public class M267_PalindromePermutationII {
    private void permutationDFS(char chars[], int pos, int L, HashSet<List<Character>> result) {
        if (pos == L) {
            ArrayList<Character> rr = new ArrayList<Character>();
            for (int i = 0; i < L; i++) rr.add(chars[i]);
            result.add(rr);
        }
        if (pos < L) {
            char tmp;

            HashSet<Character> appeared = new HashSet<Character>();

            for (int i = pos; i < L; i++) {
                if (!appeared.contains(chars[i])) {
                    appeared.add(chars[i]);

                    tmp = chars[pos];
                    chars[pos] = chars[i];
                    chars[i] = tmp;

                    permutationDFS(chars, pos + 1, L, result);

                    chars[i] = chars[pos];
                    chars[pos] = tmp;
                }
            }
        }
    }
    public List<String> generatePalindromes(String s) {
        char[] data = s.toCharArray();
        int L = data.length;
        int H = 'z'-'a';

        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        char ch;
        for (int i = 0; i < L; i++){
            ch = data[i];
            if (!counter.containsKey(ch)) counter.put(ch, 0);
            counter.put(ch, counter.get(ch) + 1);
        }

        List<String> result = new ArrayList<String>();
        int oddCnt = 0;
        for (int v : counter.values()){
            if (v % 2 == 1) oddCnt ++;
        }

        if (oddCnt > 1) return result;
        int HL = L / 2;
        char [] half_data = new char[HL];
        int HL_index = 0;
        char midChar = 'a';

        for (char ch1 : counter.keySet()){
            int vv = counter.get(ch1);

            if (vv % 2 == 1) midChar = ch1;

            for (int j = 1; j <= vv/2; j++) {
                half_data[HL_index] = ch1;
                HL_index ++;
            }
        }

        HashSet<List<Character>> buffer = new HashSet<List<Character>>();

        permutationDFS(half_data, 0, HL, buffer);
        for (List<Character> lc : buffer){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < HL; i++){
                half_data[i] = lc.get(i);
                sb.append(half_data[i]);
            }
            if (oddCnt > 0) sb.append(midChar);
            for (int i = HL-1; i >= 0; i--) sb.append(half_data[i]);
            result.add(sb.toString());
        }

        System.out.println(result);

        return result;
    }
}
