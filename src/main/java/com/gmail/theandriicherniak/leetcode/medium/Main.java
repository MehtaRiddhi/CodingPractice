package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");
        M208_ImplementTriePrefixTree t = new M208_ImplementTriePrefixTree();
        M208_ImplementTriePrefixTree.Trie trie = t.new Trie();
        trie.insert("abc");
        trie.insert("acbd");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("a"));
    }
}
