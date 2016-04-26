package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 4/25/16.
 */

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class M133_CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    private UndirectedGraphNode DFShelper(UndirectedGraphNode x, HashMap<Integer, UndirectedGraphNode> map){
        UndirectedGraphNode new_x = new UndirectedGraphNode(x.label);
        map.put(x.label, new_x);

        for (UndirectedGraphNode n : x.neighbors){
            if (!map.containsKey(n.label)) DFShelper(n, map);
            new_x.neighbors.add(map.get(n.label));
        }
        return new_x;
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

        return DFShelper(node, map);
    }
}
