package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/11/16.
 */
public class M227_BasicCalculatorII {

    public int calculate(String s) {
        char [] ar = s.replace(" ", "").toCharArray();
        int L = ar.length;
        if (L == 0) return 0;

        int number = 0;
        Character prevSign = null;

        long prevV = 0, curV = 0;

        for (int i = 0; i < L; i++){
            char ch = ar[i];
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                if (prevSign == null){
                    curV = number;
                }else {
                    if (prevSign == '+') {
                        prevV += curV;
                        curV = number;
                    } else if (prevSign == '-') {
                        prevV += curV;
                        curV = -number;
                    } else if (prevSign == '*'){
                        curV *= number;
                    } else curV /= number;
                }
                prevSign = ch;
                number = 0;
            } else {
                number = 10 * number + ch - '0';
            }
        }

//        System.out.println(prevV + " " + curV + " " + prevSign + " " + number);

        if (prevSign == null){
            curV = number;
        }else {
            if (prevSign == '+') {
                prevV += curV;
                curV = number;
            } else if (prevSign == '-') {
                prevV += curV;
                curV = -number;
            } else if (prevSign == '*'){
                curV *= number;
            } else curV /= number;
        }

        return (int) (prevV + curV);
    }
}
