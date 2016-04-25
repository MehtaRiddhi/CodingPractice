package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/24/16.
 */
import java.util.*;

public class H301_RemoveInvalidParentheses {
    private void DFS(String s, int L, int i, int removeL, int removeR, int openCount, StringBuilder sb, HashSet<String> result){
        if (i == L && removeL == 0 && removeR == 0 && openCount == 0) result.add(sb.toString());
        if (i >= L || removeL < 0 || removeR < 0 || openCount < 0) return;


        char ch = s.charAt(i);
        int len = sb.length();
        if (ch == '('){
            DFS(s, L, i + 1, removeL - 1, removeR, openCount, sb, result);
            DFS(s, L, i + 1, removeL, removeR, openCount + 1, sb.append(ch), result);
        }else if (ch == ')'){
            DFS(s, L, i + 1, removeL, removeR - 1, openCount, sb, result);
            DFS(s, L, i + 1, removeL, removeR, openCount - 1, sb.append(ch), result);
        }else DFS(s, L, i + 1, removeL, removeR, openCount, sb.append(ch), result);

        sb.setLength(len);

    }

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<String>();
        int removeL = 0;
        int removeR = 0;
        int L = s.length();

        for (int i = 0; i < L; i++){
            if (s.charAt(i) == '(') removeL ++;
            if (s.charAt(i) == ')'){
                if (removeL > 0) removeL --;
                else removeR ++;
            }
        }

        DFS(s, L, 0, removeL, removeR, 0, new StringBuilder(), result);

        return new ArrayList<String>(result);
    }
}
