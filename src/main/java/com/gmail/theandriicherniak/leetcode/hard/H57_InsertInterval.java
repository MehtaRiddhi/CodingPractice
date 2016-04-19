package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/18/16.
 */
import java.util.*;

public class H57_InsertInterval {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private void insertElement(List<Interval> result, Interval element){
        int L = result.size();
        if (L == 0) result.add(element);
        else {
            Interval ii = result.get(L-1);
            if (ii.end >= element.start){
                ii.end = Math.max(ii.end, element.end);
            }else {
                result.add(element);
            }
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();

        boolean newInserted = false;

        for (Interval i : intervals){
            if (i.start <= newInterval.start) insertElement(result, i);
            else {
                if (!newInserted) {
                    insertElement(result, newInterval);
                    newInserted = true;
                }
                insertElement(result, i);
            }
        }

        if (!newInserted) insertElement(result, newInterval);

        return result;
    }
}
