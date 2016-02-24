package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/23/16.
 */
import java.util.*;

public class M211_AddSearchWord {

    class TrieNode {
        HashMap<Character, TrieNode> links = new HashMap<Character, TrieNode>();
        boolean isLeaf = false;
    }

    private TrieNode root;

    public M211_AddSearchWord(){root = new TrieNode();}

    public void addWord(String word) {
        char [] data = word.toCharArray();
        TrieNode ptr = root;
        char ch;
        for (int i = 0; i < data.length; i++){
            ch = data[i];
            if (!ptr.links.containsKey(ch)) ptr.links.put(ch, new TrieNode());
            ptr = ptr.links.get(ch);
        }
        ptr.isLeaf = true;
    }

    private TrieNode searchHelper(TrieNode root, char[] data, int L, int i){
        TrieNode ptr;

        if (data[i] != '.'){
            if (!root.links.containsKey(data[i])) return null;
            ptr = root.links.get(data[i]);
            if (i == L) {
                if (ptr.isLeaf) return ptr;
                else return null;
            }

            else return searchHelper(ptr, data, L, i+1);

        }else{
            for (TrieNode n : root.links.values()){
                if (i == L) {
                    if (n.isLeaf) return n;
                }else {
                    ptr = searchHelper(n, data, L, i+1);
                    if (ptr != null) return ptr;
                }
            }
        }

        return null;
    }

    public boolean search(String word) {
        char [] data = word.toCharArray();
        TrieNode n = searchHelper(root, data, data.length - 1, 0);
        if (n == null || !n.isLeaf) return false;

        return true;
    }
}
