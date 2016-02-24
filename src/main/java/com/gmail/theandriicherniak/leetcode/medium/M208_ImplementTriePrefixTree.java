package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 2/23/16.
 */
import java.util.*;

public class M208_ImplementTriePrefixTree {
    class TrieNode {
        HashMap<Character, TrieNode> links = new HashMap<Character, TrieNode>();
        boolean isLeaf = false;

        public TrieNode() {

        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
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

        private TrieNode getNode(String word){
            char [] data = word.toCharArray();
            TrieNode ptr = root;
            char ch;

            for (int i = 0; i < data.length; i++){
                ch = data[i];
                if (!ptr.links.containsKey(ch)) return null;
                ptr = ptr.links.get(ch);
            }
            return ptr;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode n = getNode(word);
            if (n == null || !n.isLeaf) return false;
            return true;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode n = getNode(prefix);
            if (n == null) return false;
            return true;
        }
    }
}
