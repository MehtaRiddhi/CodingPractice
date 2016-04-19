package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/18/16.
 */

import java.util.*;

public class H56_MergeIntervals {
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

    public class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            if (i1.start < i2.start) return -1;
            if (i1.start > i2.start) return 1;
            return 0;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return intervals;
        Collections.sort(intervals, new IntervalComparator());

        ArrayList<Interval> result = new ArrayList<Interval>();
        int resultL = 0;

        for (Interval i : intervals){
            if (resultL == 0) {
                result.add(i);
                resultL ++;
            }else {
                Interval ii = result.get(resultL - 1);
                if (ii.end >= i.start) ii.end = Math.max(ii.end, i.end);
                else {
                    result.add(i);
                    resultL++;
                }
            }
        }

        return result;
    }
}
