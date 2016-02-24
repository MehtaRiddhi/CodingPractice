package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;

/**
 * Created by andriicherniak on 2/23/16.
 */
public class M210_CourseScheduleII {
    private boolean hasCycle(int v, int [] marked, ArrayList<ArrayList<Integer>> dependencies){
        if (marked[v] == 1) return true;
        marked[v] = 1;
        for (int vv : dependencies.get(v)){
            if (hasCycle(vv, marked, dependencies)) return true;
        }
        marked[v] = 2;
        return false;
    }

    private void topologicalSort(int v, int [] marked, ArrayList<ArrayList<Integer>> dependends_on, ArrayList<Integer> buffer){
        if (marked[v] == 1) return;
        for (int vv : dependends_on.get(v)){
            topologicalSort(vv, marked, dependends_on, buffer);
        }
        marked[v] = 1;
        buffer.add(v);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] order = new int[0];

        ArrayList<ArrayList<Integer>> dependencies = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> dependends_on = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            dependencies.add(new ArrayList<Integer>());
            dependends_on.add(new ArrayList<Integer>());

        }

        int [] marked  = new int[numCourses];
        int [] link_count = new int[numCourses];

        for (int [] p : prerequisites){
            dependencies.get(p[1]).add(p[0]);
            dependends_on.get(p[0]).add(p[1]);
            link_count[p[1]] ++;
        }

        for (int i = 0; i < numCourses; i++){
            if (link_count[i] > 0 && marked[i] == 0){
                if (hasCycle(i, marked, dependencies)) return order;
            }
        }

        order = new int[numCourses];
        ArrayList<Integer> buffer = new ArrayList<Integer>();

        for (int i = 0; i < numCourses; i++) marked[i] = 0;
        for (int i = 0 ; i < numCourses; i++){
            if (marked[i] == 0){
                topologicalSort(i, marked, dependends_on, buffer);
            }
        }

        for (int i = 0; i < numCourses; i++){
            order[i] = buffer.get(i);
        }

        return order;
    }
}
