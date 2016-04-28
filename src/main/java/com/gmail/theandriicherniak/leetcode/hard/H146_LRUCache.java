package com.gmail.theandriicherniak.leetcode.hard;

import java.util.*;

/**
 * Created by andriicherniak on 4/28/16.
 */
public class H146_LRUCache {

    LinkedHashMap<Integer, Integer> map;

    public H146_LRUCache(final int capacity) {

        map = new LinkedHashMap<Integer, Integer>(capacity + 1, (float) 0.5, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) return map.get(key);
        else return -1;
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
