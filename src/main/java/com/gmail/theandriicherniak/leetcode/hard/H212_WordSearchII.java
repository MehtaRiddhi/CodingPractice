package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 2/24/16.
 */

import java.util.*;

public class H212_WordSearchII {
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

    private void searchHelper(char[][] board, boolean[][] bitmap, Trie trie, int r, int c, int R, int C, String prefix, HashSet<String> buffer ){
        if (r < 0 || c < 0 || r >= R || c >= C) return;
        if (bitmap[r][c]) return;
        String s = prefix + board[r][c];

        if (!trie.startsWith(s)) return;

        if (trie.search(s)) buffer.add(s);

        bitmap[r][c] = true;

        searchHelper(board, bitmap, trie, r - 1, c, R, C, s, buffer);
        searchHelper(board, bitmap, trie, r, c - 1, R, C, s, buffer);
        searchHelper(board, bitmap, trie, r + 1, c, R, C, s, buffer);
        searchHelper(board, bitmap, trie, r, c + 1, R, C, s, buffer);

        bitmap[r][c] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> result = new ArrayList<String>();
        HashSet<String> buffer = new HashSet<String>();

        int R = board.length;
        if (R == 0) return result;
        int C = board[0].length;

        boolean[][] bitmap = new boolean[R][C];

        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                searchHelper(board, bitmap, trie, r, c, R, C, "", buffer);
            }
        }

        for (String word : buffer) result.add(word);
        System.out.println(result);

        return result;
    }


}
