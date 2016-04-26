package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by andriicherniak on 4/26/16.
 */
public class M277_FindCelebrity {
    boolean knows(int a, int b){
        if (a == 0 && b == 1) return true;
        if (a == 1 && b == 2) return true;
        if (a == 2 && b == 1) return true;
        return false;
    }
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        if (n == 1) return -1;

        int [] knows_me_count = new int[n];
        int [] i_know_count = new int[n];

        HashSet<Integer> candidates = new HashSet<Integer>();
        for (int c = 1; c < n; c++){
            if (knows(0, c)) {
                candidates.add(c);
                i_know_count[0]++;
                knows_me_count[c]++;
            }
        }

        candidates.add(0);
        int [] remove_candidates = new int[n];
        int removeCount;

        for (int i = 1; i < n; i++){
            removeCount = 0;
            for (int c : candidates){
                if (c != i) {
                    if (knows(i, c)) {
                        i_know_count[i]++;
                        knows_me_count[c]++;
                    } else {
                        remove_candidates[removeCount] = c;
                        removeCount++;
                    }
                }
            }
            for (int id = 0; id < removeCount; id++) candidates.remove(remove_candidates[id]);

        }


        for (int c : candidates){
            if (knows_me_count[c] == n-1 && i_know_count[c] == 0){
                int id = 0;
                while (id < n && (id == c || !knows(c, id))){
                    id ++;
                }
                if (id == n) return c;
            }
        }
        return -1;
    }
}
