package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/23/16.
 */
public class M43_MultiplyStrings {

    private int[] sToI(String num){
        char [] ar = num.toCharArray();
        int L = ar.length;
        int [] result = new int[L];
        for (int i = 0; i < L; i++) result[i] = ar[i] - '0';
        return result;
    }

    private void multiply(int [] number, int numberL, int v, int [] buffer, int pos){
        int memory = 0;
        int res;
        for (int i = 1; i <= numberL; i++){
            res = number[numberL - i]*v + memory;
            buffer[pos] = res % 10;
            memory = res / 10;
            pos --;
        }
        if (memory > 0) buffer[pos] = memory;
    }

    private void add(int [] numberFrom, int [] numberTo, int posFrom, int posTo){
        int memory = 0;
        int res;
        while (posFrom >= 0 && posTo >= 0){
            res = numberFrom[posFrom] + numberTo[posTo] + memory;
            numberTo[posTo] = res % 10;
            memory = res / 10;
            posFrom --;
            posTo --;
        }
    }

    public String multiply(String num1, String num2) {
        int [] num1int = sToI(num1);
        int [] num2int = sToI(num2);

        int L1 = num1int.length;
        int L2 = num2int.length;

        if (L2 > L1){
            int [] tmpInt;
            int tmpL = L1;

            tmpInt = num1int;
            num1int = num2int;
            num2int = tmpInt;

            L1 = L2;
            L2 = tmpL;
        }

        int LL = L1 + L2 + 1;
        int [] buffer1 = new int[LL];
        int [] buffer2 = new int[LL];

        for (int i = 1; i <= L2; i ++){
            for (int j = 0; j < LL; j++) buffer1[j] = 0;

            multiply(num1int, L1, num2int[L2 - i], buffer1, LL - 1);
            add(buffer1, buffer2, LL - 1, LL - i);
        }

        StringBuilder sb = new StringBuilder();
        boolean seenDigit = false;

        for (int i = 0; i < LL; i++) {
            if (buffer2[i] > 0 || seenDigit){
                seenDigit = true;
                sb.append(buffer2[i]);
            }
        }

        if (!seenDigit) sb.append(0);

        return sb.toString();
    }
}
