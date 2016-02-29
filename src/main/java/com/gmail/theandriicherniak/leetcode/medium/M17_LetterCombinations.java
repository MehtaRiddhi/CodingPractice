package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/29/16.
 */
import java.util.*;

public class M17_LetterCombinations {
    private void letterHelper(int[] nums, int L, int pos, char[][] digitCharMapping, char[] buffer, List<String> result){
        if (pos == L){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) sb.append(buffer[i]);
            result.add(sb.toString());
        }
        if (pos < L){
            char[] letters = digitCharMapping[nums[pos]];
            for (char ch : letters){
                buffer[pos] = ch;
                letterHelper(nums, L, pos + 1, digitCharMapping, buffer, result);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        char[][] digitCharMapping = new char[10][];
        digitCharMapping[0] = new char[]{' '};
        digitCharMapping[2] = new char[]{'a','b','c'};
        digitCharMapping[3] = new char[]{'d','e','f'};
        digitCharMapping[4] = new char[]{'g','h','i'};
        digitCharMapping[5] = new char[]{'j','k','l'};
        digitCharMapping[6] = new char[]{'m','n','o'};
        digitCharMapping[7] = new char[]{'p','q','r','s'};
        digitCharMapping[8] = new char[]{'t','u','v'};
        digitCharMapping[9] = new char[]{'w','x','y','z'};

        char[] data = digits.toCharArray();
        int L = data.length;
        int [] nums = new int[L];
        for (int i = 0; i < L; i++) nums[i] = Integer.parseInt(""+data[i]);

        List<String> result = new ArrayList<String>();
        if (L == 0) return result;
        char[] buffer = new char[L];

        letterHelper(nums, L, 0, digitCharMapping, buffer, result);
        System.out.println(result);

        return result;
    }
}
