package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/12/16.
 */
public class M186_ReverseWordsStringII {

    private void swap(char [] s, int from, int to){
        if (from >= to) return;
        char ch;
        while (from < to){
            ch = s[from];
            s[from] = s[to];
            s[to] = ch;
            from ++;
            to --;
        }
    }

    public void reverseWords(char[] s) {
        int L = s.length;
        if (L <= 1) return;
        swap(s, 0, L-1);
        int start = 0;

        for (int i = 0; i < L; i++){
            if (s[i] == ' '){
                swap(s, start, i - 1);
                start = i + 1;
            }
        }

        swap(s, start, L-1);
    }
}
