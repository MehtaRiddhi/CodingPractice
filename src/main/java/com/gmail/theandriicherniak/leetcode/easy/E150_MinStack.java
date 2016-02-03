package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/2/16.
 */
public class E150_MinStack {
    private int[][] stack = new int[50000][2];
    private int pos = -1;

    private int min(int a, int b){
        if (a < b) return a;
        else return b;
    }

    public void push(int x) {
        stack[++pos][0]=x;
        if (pos == 0) stack[pos][1] = x;
        else stack[pos][1] = min(stack[pos - 1][1], x);
    }

    public void pop() {
        pos--;
    }

    public int top() {
        return stack[pos][0];
    }

    public int getMin() {
        return stack[pos][1];
    }
}
