package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 5/5/16.
 */
import java.util.*;
public class M284_PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private boolean hasNextElement;
    private int nextElement;

    public M284_PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        hasNextElement = iter.hasNext();
        nextElement = 0;
        if (hasNextElement) nextElement = iter.next();
    }

    public Integer peek() {
        return nextElement;
    }

    public Integer next() {
        if (!hasNextElement) return null;
        else {
            int res = nextElement;
            hasNextElement = iter.hasNext();
            if (hasNextElement) nextElement = iter.next();
            return res;
        }
    }

    public boolean hasNext() {
        return hasNextElement;
    }
}
