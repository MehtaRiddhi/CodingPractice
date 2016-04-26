package com.gmail.theandriicherniak.leetcode.medium;

import java.util.HashSet;

/**
 * Created by andriicherniak on 4/26/16.
 */
public class M277_FindCelebrity {
    boolean knows(int a, int b){
        if (a == 0 && b == 1) return true;
        if (a == 2 && b == 1) return true;
        if (a == 2 && b == 0) return true;
        return false;
    }
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        if (n == 1) return -1;

        int [] knows_me_count = new int[n];
        int [] i_know_count = new int[n];

        int [] candidates = new int[n];
        int cL = 0;
        for (int c = 1; c < n; c++){
            if (knows(0, c)) {
                candidates[cL] = c;
                cL ++;
                i_know_count[0]++;
                knows_me_count[c]++;
            }
        }

        candidates[cL] = 0;
        cL ++;

        HashSet<Integer> remove_candidates = new HashSet<Integer>();

        int cc;

        for (int i = 1; i < n; i++){

            for (int id = 0; id < cL; id ++){
                cc = candidates[id];

                if (cc != i) {
                    if (knows(i, cc)) {
                        i_know_count[i]++;
                        knows_me_count[cc]++;
                    } else remove_candidates.add(cc);
                }
            }

            if (remove_candidates.size() > 0){
                int new_cL = 0;
                for (int id = 0; id < cL; id++){
                    if (!remove_candidates.contains(candidates[id])) {
                        candidates[new_cL] = candidates[id];
                        new_cL ++;
                    }
                }
                cL = new_cL;
                remove_candidates.clear();
            }
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
