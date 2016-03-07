package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 3/7/16.
 */
import java.util.*;

public class M241_DifferentWaysParentheses {

    private int computeOperationResult(int val1, int val2, char operation){
        if (operation == '+') return val1 + val2;
        if (operation == '-') return val1 - val2;
        if (operation == '*') return val1 * val2;

        return 0;
    }

    private List<Integer> computeResult(int[] valBuffer, char[] operationsBuffer, int from, int to){
        System.out.println("from " + from + " to " + to);

        List<Integer> result = new ArrayList<Integer>();

        if (from >  to){
            result.add(valBuffer[from]);
            return result;
        }

        List<Integer> r1;
        List<Integer> r2;

        for (int pos = from; pos <= to; pos ++) {
            r1 = computeResult(valBuffer, operationsBuffer, from, pos - 1);
            r2 = computeResult(valBuffer, operationsBuffer, pos + 1, to);

            for (int v1 : r1){
                for (int v2 : r2){
                    int vv = computeOperationResult(v1, v2, operationsBuffer[pos]);
                    result.add(vv);
                }
            }
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        char[] ar = input.toCharArray();
        int L = ar.length;
        if (L == 0) return result;

        int valId = 0;
        int operationId = 0;

        int[] valBuffer = new int[L/2 + 1];
        char[] operationBuffer = new char[L/2 + 1];

        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < L; i++){
            ch = ar[i];
            if (ch == '+' || ch == '-' || ch == '*'){
                valBuffer[valId] = Integer.parseInt(sb.toString());
                valId ++;
                sb.setLength(0);

                operationBuffer[operationId] = ch;
                operationId ++;

            }else{
                sb.append(ch);
            }
        }

        valBuffer[valId] = Integer.parseInt(sb.toString());
        valId ++;

        for (int i = 0; i < valId; i++) System.out.print(valBuffer[i] + " ");
        for (int i = 0; i < operationId; i++) System.out.print(operationBuffer[i] + " ");

        System.out.println();

        result = computeResult(valBuffer, operationBuffer, 0, operationId - 1);
        System.out.println(result);

        return result;
    }
}
