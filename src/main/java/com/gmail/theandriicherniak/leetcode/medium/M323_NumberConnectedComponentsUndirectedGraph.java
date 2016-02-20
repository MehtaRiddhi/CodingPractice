package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/18/16.
 */
public class M323_NumberConnectedComponentsUndirectedGraph {
    private class UnionFind{
        private int v_root[];
        private int component_size[];
        private int components;

        public UnionFind(int n){
            v_root = new int[n];
            component_size = new int[n];
            for (int i = 0; i < n; i++){
                v_root[i] = i;
                component_size[i] = 1;
            }
            components = n;
        }
        public boolean connected(int p, int q){return find(p) == find(q);}
        public void union(int p, int q){
            int root_p = find(p);
            int root_q = find(q);
            if (root_p == root_q) return;

            if (component_size[root_p] < component_size[root_q]) {
                v_root[root_p] = root_q;
                component_size[root_q] += component_size[root_p];
            }else{
                v_root[root_q] = root_p;
                component_size[root_p] += component_size[root_q];
            }
            components --;
        }
        public int find(int p){
            while (p != v_root[p]) p = v_root[p];
            return p;
        }
        public int getComponents(){return components;}
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind UF = new UnionFind(n);
        int L = edges.length;
        for (int i = 0; i < L; i++){
            UF.union(edges[i][0], edges[i][1]);
        }

        return UF.getComponents();
    }
}
