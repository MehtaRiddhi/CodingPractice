package com.gmail.theandriicherniak.leetcode.medium;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by andriicherniak on 6/1/16.
 */
public class M150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int L = tokens.length;
        if (L == 0) return 0;
        if (L == 1) return Integer.parseInt(tokens[0]);

        HashSet<String> operations = new HashSet<String>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        Stack<Integer> stack = new Stack<Integer>();
        for (String t : tokens){
            if (!operations.contains(t)){
                stack.push(Integer.parseInt(t));
            }else {
                int v1 = stack.pop();
                int v2 = stack.pop();
                int v3;

                if (t.equals("+")) v3 = v1 + v2;
                else if (t.equals("-")) v3 = v2 - v1;
                else if (t.equals("*")) v3 = v1 * v2;
                else v3 = v2 / v1;

                stack.push(v3);
            }

        }
        int result = 0;
        if (!stack.isEmpty()) result = stack.peek();
        return result;
    }
}
