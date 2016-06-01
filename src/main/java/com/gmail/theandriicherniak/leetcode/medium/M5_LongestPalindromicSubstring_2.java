package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 6/1/16.
 */
public class M5_LongestPalindromicSubstring_2 {
    private void expand(char [] ar, int [] pL, int LL, int startPos){

        int counter = 0;
        if (ar[startPos] != '#') counter ++;

        int p1 = startPos - 1;
        int p2 = startPos + 1;

        while (p1 >= 0 && p2 < LL && ar[p1] == ar[p2]){
            if (ar[p1] != '#') counter += 2;
            p1 --;
            p2 ++;
        }
        pL[startPos] = counter;
    }

    public String longestPalindrome(String s) {
        int L = s.length();
        if (L <= 1) return s;
        int LL = 2*L + 1;

        char [] ar = new char[LL];
        int [] pL = new int[LL];
        boolean [] toExpand = new boolean[LL];
        for (int i = 0; i < LL; i++) toExpand[i] = true;

        int maxL = 0;
        int bestStart = 0;

        ar[0] = '#';
        for (int i = 0; i < L; i++){
            ar[2*i + 1] = s.charAt(i);
            ar[2*i + 2] = '#';
        }
        for(int i = 1; i < LL - 1; i++) {
            if (toExpand[i]) {
                expand(ar, pL, LL, i);
                int V = pL[i];

                for (int j = 1; j < V; j++ ){
                    if (pL[i-j] < V - j){
                        pL[i+j] = pL[i-j];
                        toExpand[i+j] = false;
                    }
                }
                if (V > maxL) {
                    maxL = V;
                    bestStart = i;
                }
            }
        }

        for (int i = 0; i < LL; i++) {
            System.out.print(ar[i]);
        }
        System.out.println();
        for (int i = 0; i < LL; i++) {
            System.out.print(pL[i]);
        }
        System.out.println();
        for (int i = 0; i < LL; i++) {
            System.out.print(toExpand[i] == true ? 1 : 0);
        }
        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (int i = bestStart - maxL; i <= bestStart + maxL; i++){
            if (ar[i] != '#') sb.append(ar[i]);
        }

        return sb.toString();
    }
}
