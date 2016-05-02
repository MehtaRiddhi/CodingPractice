package com.gmail.theandriicherniak.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by andriicherniak on 5/1/16.
 */
public class H269_AlienDictionary {
    private void topologicalSort(char ch, HashMap<Character, HashSet<Character>> depends_on, HashSet<Character> dictionaly_set, StringBuilder sb) {
        if (!dictionaly_set.contains(ch)) {
            dictionaly_set.add(ch);

            for (char ch2 : depends_on.get(ch)) {
                topologicalSort(ch2, depends_on, dictionaly_set, sb);
            }

            sb.append(ch);
        }
    }

    private boolean isCyclic(char v, HashMap<Character, HashSet<Character>> depends_on, HashSet<Character> visited, HashSet<Character> onStack) {
        if (!visited.contains(v)) {
            visited.add(v);
            onStack.add(v);
            for (char next : depends_on.get(v)){
                if (!visited.contains(next) && isCyclic(next, depends_on, visited, onStack)) return true;
                else if (onStack.contains(next)) return true;
            }
        }
        onStack.remove(v);
        return false;
    }

    private boolean hasCycle(HashMap<Character, HashSet<Character>> depends_on) {
        HashSet<Character> visited = new HashSet<Character>();
        HashSet<Character> onStack = new HashSet<Character>();

        for (char ch : depends_on.keySet()) {
            if (isCyclic(ch, depends_on, visited, onStack)) return true;
        }
        return false;
    }

    public String alienOrder(String[] words) {

        HashMap<Character, HashSet<Character>> depends_on = new HashMap<Character, HashSet<Character>>();
        int L = words.length;
        if (L == 0) return "";
        if (L == 1) return new StringBuilder(words[0]).toString();
        int maxL = 0;

        for (int i = 0; i < L; i++) {
            maxL = Math.max(maxL, words[i].length());
            for (char ch : words[i].toCharArray()) {
                if (!depends_on.containsKey(ch)) depends_on.put(ch, new HashSet<Character>());
            }
        }

        for (int wl = 0; wl <= maxL; wl++) {
            HashMap<String, ArrayList<String>> prefix_set = new HashMap<String, ArrayList<String>>();
            for (int i = 0; i < L; i++) {
                if (words[i].length() >= wl) {
                    String prefix = (wl == 0) ? " " : words[i].substring(0, wl);
                    if (!prefix_set.containsKey(prefix)) prefix_set.put(prefix, new ArrayList<String>());
                    if (words[i].length() > wl) prefix_set.get(prefix).add(words[i].substring(wl));
                }
            }

            for (ArrayList<String> ww : prefix_set.values()) {

                int wL = ww.size();
                for (int wId = 1; wId < wL; wId++) {
                    char ch = ww.get(wId).charAt(0);

                    for (int wId2 = 0; wId2 < wId; wId2++) {
                        char ch2 = ww.get(wId2).charAt(0);
                        if (ch != ch2) depends_on.get(ch).add(ch2);
                    }
                }
            }
        }

        System.out.println(depends_on);

        if (hasCycle(depends_on)) return "";

        HashSet<Character> dictionaly_set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();

        for (char ch : depends_on.keySet()) {
            topologicalSort(ch, depends_on, dictionaly_set, sb);
        }

        return sb.toString();
    }
}
