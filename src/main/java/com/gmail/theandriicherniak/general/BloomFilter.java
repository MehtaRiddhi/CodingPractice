package com.gmail.theandriicherniak.general;

import java.util.Random;

/**
 * Created by andriicherniak on 5/25/16.
 */

public class BloomFilter {
    private int N, m;
    private Random rnd;
    private long [] a;
    private long [] b;
    private long [] p;
    private boolean [] bitMask;

    private int sieve(boolean [] candidates, int [] p_val, int minP){
        int L = candidates.length - 1;
        int p_id = 0;

        for (int i = 2; i <= L; i++){
            if (!candidates[i]){
                if (i >= minP){
                    p_val[p_id] = i;
                    p_id ++;
                }
                int v = i;
                while (v <= L){
                    candidates[v] = true;
                    v += i;
                }
            }
        }

        return p_id;
    }

    BloomFilter(int Nhash, int modulo){
        N = Nhash;
        m = modulo;
        rnd = new Random();

        a = new long[N];
        b = new long[N];
        p = new long[N];

        bitMask = new boolean[modulo];

        int upperLimit = Math.min(2 * modulo, Integer.MAX_VALUE);

        boolean [] candidates = new boolean[upperLimit + 1];
        int [] p_val = new int[modulo];
        int Lp = sieve(candidates, p_val, modulo);

        for (int i = 0; i < N; i++){
            int id = rnd.nextInt(Lp);
            p[i] = p_val[id];
            a[i] = 1 + rnd.nextInt(p_val[id] - 1);
            b[i] = 1 + rnd.nextInt(p_val[id] - 1);
        }
    }

    private int hash(int v, int id){
        long H = 0;
        long v1 = (v % p[id]);
        long scalor = 1;

        long v2;

        while (v1 > 0){
            v2 = (v1 % 10) * scalor;
            H = (H + a[id] * v2) % p[id];
            scalor *= 10;
            v1 = v1 / 10;
        }
        H += b[id];
        H %= p[id];
        H %= m;
//        System.out.println("H " + H);
        return (int) H;
    }

    private int[] hashV(int v){
        int [] result = new int[N];
        for (int i = 0; i < N; i++){
            result[i] = hash(v, i);
        }
        return result;
    }

    public void add(int v){
        int [] V = hashV(v);
        for (int i = 0; i < N; i++) bitMask[V[i]] = true;
    }

    public boolean contains(int v){
        int [] V = hashV(v);
        int conflict = 0;
        for (int i = 0; i < N; i++) {
            if (bitMask[V[i]]) conflict ++;
        }
        if (conflict == N) return true;
        return false;
    }
}
