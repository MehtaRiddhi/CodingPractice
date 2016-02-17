package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/17/16.
 */
import java.util.Stack;
public class E20_ValidParentheses {
    public boolean isValid(String s) {
        char[] s_ar = s.toCharArray();
        int L = s_ar.length;
        if (L == 0) return true;
        if (L % 2 == 1) return false;

        char stackTopChar;

        Stack<Character> stack = new Stack<Character>();
        for (char ch : s_ar){
            if (stack.empty()) stack.push(ch);
            else {
                stackTopChar = stack.peek();
                if (stackTopChar == '(' && ch == ')') stack.pop();
                else if (stackTopChar == '{' && ch == '}') stack.pop();
                else if (stackTopChar == '[' && ch == ']') stack.pop();
                else stack.push(ch);
            }
        }
        if (stack.empty()) return true;
        return false;
    }
}
