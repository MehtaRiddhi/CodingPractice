package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/24/16.
 */
public class M161_OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        int Ls = s.length();
        int Lt = t.length();
        int diff = 0;

        if (Ls == Lt){
            for (int i = 0; i < Ls; i ++){
                if (s.charAt(i) != t.charAt(i)) diff ++;
                if (diff > 1) return false;
            }
            if (diff == 0) return false;
            return true;
        }
        if (Math.abs(Ls - Lt) > 1) return false;
        if (Ls == 0 || Lt == 0) return true;

        int sId = 0;
        int tId = 0;
        while (diff <= 1 && sId < Ls && tId < Lt){
            if (s.charAt(sId) != t.charAt(tId)){
                diff ++;
                if (Ls > Lt) sId ++;
                else tId ++;
            }else {
                sId ++;
                tId ++;
            }
        }
        if (diff == 0 && (Ls - sId == 1 || Lt - tId == 1)) return true;
        if (diff > 1) return false;
        return true;
    }
}
