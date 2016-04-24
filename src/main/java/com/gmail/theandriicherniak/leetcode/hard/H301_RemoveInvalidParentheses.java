package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/24/16.
 */
import java.util.*;

public class H301_RemoveInvalidParentheses {

    private boolean matchedParenthesis(char [] ar, int L){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < L; i++){
            if (ar[i] == '(' || ar[i] == ')'){
                if (stack.empty()) stack.push(ar[i]);
                else if (ar[i] == ')' && stack.peek() == '(') stack.pop();
                else stack.push(ar[i]);
            }
        }

        return stack.empty();
    }
    private void removeParenthesis(char [] ar, int from, int to, int L, int count, HashSet<String> result){
        if (count == 0){

            if (matchedParenthesis(ar, L)){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < L; i++) if (ar[i] != ' ') sb.append(ar[i]);
                result.add(sb.toString());
            }
        }else {
            char ch;
            for (int i = from; i <= to; i++) {
                if (ar[i] == '(' || ar[i] == ')'){
                    ch = ar[i];
                    ar[i] = ' ';
                    removeParenthesis(ar, i + 1, to, L, count - 1, result);
                    ar[i] = ch;
                }
            }
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> rr = new HashSet<String>();
        ArrayList<String> result = new ArrayList<String>();
        char [] ar = s.toCharArray();
        int L = ar.length;

        if (matchedParenthesis(ar, L)) result.add(s);
        else {
            for (int count = 1; count <= L; count++){
                removeParenthesis(ar, 0, L-1, L, count, rr);
                if (rr.size() > 0) {
                    for (String rs : rr) result.add(rs);
                    return result;
                }
            }
        }

        return result;
    }
}
