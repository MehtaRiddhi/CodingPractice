package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/23/16.
 */
import java.util.*;

public class M207_CourseSchedule {

    private boolean hasCycle(int v, int [] marked, ArrayList<ArrayList<Integer>> dependencies){
        if (marked[v] == 1) return true;
        marked[v] = 1;
        for (int vv : dependencies.get(v)){
            if (hasCycle(vv, marked, dependencies)) return true;
        }
        marked[v] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> dependencies = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) dependencies.add(new ArrayList<Integer>());

        int [] marked  = new int[numCourses];
        int [] link_count = new int[numCourses];

        for (int [] p : prerequisites){
            dependencies.get(p[1]).add(p[0]);
            link_count[p[1]] ++;
        }


        for (int i = 0; i < numCourses; i++){
            if (link_count[i] > 0 && marked[i] == 0){
                if (hasCycle(i, marked, dependencies)) return false;
            }
        }

        return true;
    }
}
