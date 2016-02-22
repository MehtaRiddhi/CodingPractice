package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/20/16.
 */

import java.util.*;

public class M332_ReconstructItinerary {

    private boolean DFS(String curr, List<String> ans, HashMap<String, ArrayList<String>> graph, int n) {
        ans.add(curr);
        if (ans.size() >= n) {
            return true;
        }
        if (!graph.containsKey(curr) || graph.get(curr).isEmpty()) {
            return false;
        }
        ArrayList<String> arrivals = graph.get(curr);
        for (int i = 0; i < arrivals.size(); i++) {
            String arrival = graph.get(curr).remove(i);
            if (DFS(arrival, ans, graph, n)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            arrivals.add(i, arrival);
        }
        return false;
    }

    public List<String> findItinerary(String[][] tickets) {

        HashMap<String, ArrayList<String>> trips = new HashMap<String, ArrayList<String>>();


        String from, to;

        for (String [] ticket : tickets){
            from = ticket[0];
            to = ticket[1];

            if (!trips.containsKey(from)) trips.put(from, new ArrayList<String>());
            trips.get(from).add(to);

        }

        for (ArrayList<String> dest: trips.values()){
            Collections.sort(dest);
        }

        ArrayList<String> ans = new ArrayList<String>();
        DFS("JFK", ans, trips, tickets.length + 1);

        return ans;
    }
}
