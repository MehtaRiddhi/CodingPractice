package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/20/16.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class M261_GraphValidTree {

    private boolean isCyclic(int v, boolean[] visited, HashMap<Integer, ArrayList<Integer>> adj, int parent){
        if (visited[v] && v != parent) return true;
        visited[v] = true;
        if (adj.containsKey(v)) {
            for (int next : adj.get(v)) {
                if (next != parent) {
                    if (isCyclic(next, visited, adj, v)) return true;
                }
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            visited[i] = false;
        }

        int p, q;

        int L = edges.length;
        for (int i = 0; i < L; i++){
            p = edges[i][0];
            q = edges[i][1];
            if (!adj.containsKey(p)) adj.put(p, new ArrayList());
            if (!adj.containsKey(q)) adj.put(q, new ArrayList());

            adj.get(p).add(q);
            adj.get(q).add(p);
        }

        boolean isValid = !isCyclic(0, visited, adj, -1);


        for (int i = 0; i < n; i++){
            System.out.println(visited[i]);
            isValid = isValid && visited[i];
        }

        return isValid;
    }
}
