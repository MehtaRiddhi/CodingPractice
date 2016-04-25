package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/25/16.
 */
import java.util.*;

public class H218_TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        ArrayList<int[]> result = new ArrayList<int[]>();

        int L = buildings.length;
        if (L == 0) return result;

        HashMap<Integer, ArrayList<Integer>> criticalData = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i< L; i++){
            if (!criticalData.containsKey(buildings[i][0]))
                criticalData.put(buildings[i][0], new ArrayList<Integer>());

            if (!criticalData.containsKey(buildings[i][1]))
                criticalData.put(buildings[i][1], new ArrayList<Integer>());

            criticalData.get(buildings[i][0]).add(i);
            criticalData.get(buildings[i][1]).add(i);
        }

        int CPL = criticalData.size();
        int [] criticalPoints = new int [CPL];
        int [] criticalValues = new int [CPL];

        CPL = 0;
        for (int i : criticalData.keySet()) criticalPoints[CPL++] = i;
        Arrays.sort(criticalPoints);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());

        int x;
        for (int i = 0; i < CPL; i++) {
            x = criticalPoints[i];
            for (int b : criticalData.get(x)){
                if (buildings[b][0] == x) q.add(buildings[b][2]);
                else q.remove(buildings[b][2]);
            }
            if (!q.isEmpty()) criticalValues[i] = q.peek();
        }

        result.add(new int[]{criticalPoints[0], criticalValues[0]});
        int prevV = criticalValues[0];
        for (int i = 1; i < CPL; i++){
            if (criticalValues[i] != prevV){
                result.add(new int[]{criticalPoints[i], criticalValues[i]});
            }
            prevV = criticalValues[i];
        }

        return result;
    }
}