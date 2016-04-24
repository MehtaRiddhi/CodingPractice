package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/23/16.
 */
public class M43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        
        StringBuilder sb = new StringBuilder();

        char [] ar1 = num1.toCharArray();


        return sb.toString();
    }
}
