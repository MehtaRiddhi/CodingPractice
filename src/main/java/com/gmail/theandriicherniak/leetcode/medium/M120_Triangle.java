package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/14/16.
 */
import java.util.*;

public class M120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int L = triangle.size();
        if (L == 0) return 0;

        int [] buffer1 = new int[L];
        int [] buffer2 = new int[L];
        int [] bufferTmp;

        buffer2[0] = triangle.get(0).get(0);

        int level = 0;
        int id;
        int v1, v2;

        for (List<Integer> l : triangle){
            level ++;
            id = 0;
            if (level > 1){
                for (int v : l){
                    v1 =  (id - 1 >= 0) ? buffer1[id-1] : Integer.MAX_VALUE;
                    v2 = (id < level - 1) ? buffer1[id] : Integer.MAX_VALUE;

                    buffer2[id] = v + Math.min(v1, v2);
                    System.out.println(buffer2[id] + " ");


                    id ++;
                }
            }

            System.out.println();

            bufferTmp = buffer1;
            buffer1 = buffer2;
            buffer2 = bufferTmp;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < L; i++){
            result = Math.min(result, buffer1[i]);
        }

        return result;
    }
}
