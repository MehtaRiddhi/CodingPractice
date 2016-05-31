package com.gmail.theandriicherniak.general;

/**
 * Created by andriicherniak on 5/13/16.
 */
public class StringMatch {
    /*
    brute force match
     */

    public int match_BF(String s, String p){
        int Ls = s.length();
        if (Ls == 0) return -1;
        int Lp = p.length();

        if (Lp == 0) return -1;
        if (Ls < Lp) return -1;

        for (int si = 0; si <= Ls - Lp; si ++){
            int pi;
            for (pi = 0; pi < Lp; pi ++){
                if (s.charAt(si + pi) != p.charAt(pi)) break;
            }
            if (pi == Lp) return si;
        }

        return -1;
    }

    private int [] backtrackArray(String p){
        int [] backtrack = new int[p.length()];
        int index = 0;
        for (int i = 1; i < p.length();){
            if (p.charAt(i) == p.charAt(index)) {
                backtrack[i] = index + 1;
                index ++;
                i++;
            }else {
                if (index > 0) index = backtrack[index - 1];
                else {
                    backtrack[i] = 0;
                    i ++;
                }
            }
        }

        return backtrack;
    }

    /*
    string match using KMP
     */

    public int match_KMP(String s, String p){
        int Ls = s.length();
        if (Ls == 0) return -1;
        int Lp = p.length();

        if (Lp == 0) return -1;
        if (Ls < Lp) return -1;

        int i = 0, j = 0;
        int [] T = backtrackArray(p);

        while (i < Ls && j < Lp){
            if (s.charAt(i) == p.charAt(j)){
                i++;
                j++;
                if (j == Lp) return i - j;
            }else {
                if (j > 0) j = T[j-1];
                else i++;
            }
        }

        return -1;
    }
}
