package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/10/16.
 */

import java.util.PriorityQueue;
import java.util.Comparator;

public class E252_MeetingRooms {
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
        public int compare(Interval it1, Interval it2){
            if (it1.start < it2.start) return -1;
            if (it1.start > it2.start) return 1;
            return 0;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return true;
        if (intervals.length <= 1) return true;
        int L = intervals.length;

        PriorityQueue<Interval> q = new PriorityQueue<Interval>(L, new IntervalComparator());
        for (Interval it : intervals) q.add(it);
        Interval it = q.remove();
        int end_time = it.end;

        while (!q.isEmpty()){
            it = q.remove();
            if (it.start < end_time) return false;
            end_time = it.end;
        }
        return true;
    }
}
