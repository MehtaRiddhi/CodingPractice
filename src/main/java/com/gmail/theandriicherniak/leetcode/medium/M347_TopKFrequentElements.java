package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/4/16.
 */

import java.util.*;

public class M347_TopKFrequentElements {
    private class NumCount{
        int value;
        int cnt;
        public NumCount(int v, int c){
            value = v;
            cnt = c;
        }
    }

    private class C implements Comparator<NumCount>{
        public int compare(NumCount n1, NumCount n2){
            if (n1.cnt > n2.cnt) return 1;
            if (n1.cnt < n2.cnt) return -1;
            return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();

        for (int v : nums){
            if (!buffer.containsKey(v)) buffer.put(v, 1);
            else buffer.put(v, buffer.get(v) + 1);
        }

        PriorityQueue<NumCount> q = new PriorityQueue<NumCount>(k + 1, new C());
        for (int key : buffer.keySet()){
            q.add(new NumCount(key, buffer.get(key)));
            if (q.size() > k) q.remove();
        }

        while (!q.isEmpty()){
            result.add(q.remove().value);
        }

        return result;
    }
}
