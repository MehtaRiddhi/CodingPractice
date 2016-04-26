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


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        UndirectedGraphNode n;
        while (!stack.empty()){
            n = stack.pop();
            if (!map.containsKey(n)) {
                map.put(n, new UndirectedGraphNode(n.label));
                for (UndirectedGraphNode next : n.neighbors) stack.push(next);
            }
        }

        stack.setSize(0);

        stack.push(node);
        while (!stack.empty()){
            n = stack.pop();
            if (n.neighbors.size() > map.get(n).neighbors.size()){
                for (UndirectedGraphNode nn : n.neighbors){
                    map.get(n).neighbors.add(map.get(nn));
                    stack.push(nn);
                }
            }
        }

        return map.get(node);
    }
}
