package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/26/16.
 */
public class M277_FindCelebrity {
    boolean knows(int a, int b){
        return true;
    }
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        if (n == 1) return -1;

        int [] knows_me_count = new int[n];
        int [] i_know_count = new int[n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j ++){
                if (i != j){
                    if (knows(i, j)) {
                        knows_me_count[j] ++;
                        i_know_count[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (knows_me_count[i] == n-1 && i_know_count[i] == 0) return i;
        }
        return -1;
    }
}
