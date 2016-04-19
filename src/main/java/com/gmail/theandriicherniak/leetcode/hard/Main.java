package com.gmail.theandriicherniak.leetcode.hard;
import com.gmail.theandriicherniak.leetcode.hard.H57_InsertInterval.Interval;
import javafx.collections.ArrayChangeListener;

/**
 * Created by andriicherniak on 3/16/16.
 */

import java.util.*;

public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H57_InsertInterval ii = new H57_InsertInterval();
        Interval i1 = ii.new Interval(1,5);
        Interval i2 = ii.new Interval(0,3);

        List<Interval> il = new ArrayList<Interval>();
        il.add(i1);

        for (Interval i : ii.insert(il, i2)) System.out.println(i.start + " " + i.end);

    }
}
