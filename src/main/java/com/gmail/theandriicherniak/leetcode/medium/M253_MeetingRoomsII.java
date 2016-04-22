package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/21/16.
 */
import java.util.*;

public class M253_MeetingRoomsII {
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

    public int minMeetingRooms(Interval[] intervals) {
        int L = intervals.length;
        if (L == 0) return 0;
        if (L == 1) return 1;

        PriorityQueue<Interval> q1 = new PriorityQueue<Interval>(L, new IntervalComparator());
        PriorityQueue<Interval> q2 = new PriorityQueue<Interval>(L, new IntervalComparator());


        for (Interval i : intervals){
            q1.add(i);
        }
        int end;
        int rooms = 0;

        while (!q1.isEmpty()) {

            end = q1.remove().end;

            while (!q1.isEmpty()) {
                Interval i = q1.remove();
                if (i.start >= end) end = i.end;
                else q2.add(i);
            }

            q1 = q2;
            q2 = new PriorityQueue<Interval>(L, new IntervalComparator());
            rooms ++;
        }
        return rooms;
    }
}
