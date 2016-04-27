package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/27/16.
 */

public class M71_SimplifyPath {
    public String simplifyPath(String path) {

        String [] pathAr = path.split("/");
        int L = pathAr.length;

        String [] newPath = new String[L];
        int newPathLen = 0;

        StringBuilder sb = new StringBuilder();
        if (L == 0) return "/";

        for (int i = 0; i < L; i++){
            String s = pathAr[i].trim();
            if (!s.equals("") && !s.equals(".")){
                if (s.equals("..")) newPathLen = Math.max(newPathLen - 1, 0);
                else {
                    newPath[newPathLen] = s;
                    newPathLen++;
                }
            }
        }

        if (newPathLen == 0) return "/";
        else for (int i = 0; i < newPathLen; i++) sb.append("/" + newPath[i]);

        return sb.toString();
    }
}
