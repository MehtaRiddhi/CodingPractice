package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/17/16.
 */
import java.util.ArrayList;

public class E38_CountAndSay {
    private ArrayList<Integer> countHelper(ArrayList<Integer> input){
        ArrayList<Integer> result = new ArrayList<Integer>();

        int val = input.get(0);
        int counter = 0;
        for (int el : input){
            if (el == val) counter ++;
            else {
                result.add(counter);
                result.add(val);
                val = el;
                counter = 1;
            }
        }

        result.add(counter);
        result.add(val);
        return result;
    }
    public String countAndSay(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n >= 1) result.add(1);
        for (int i = 2; i <= n; i++){
            result = countHelper(result);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) sb.append(i);
        return sb.toString();
    }
}
