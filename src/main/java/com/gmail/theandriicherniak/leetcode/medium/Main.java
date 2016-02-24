package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");

        M211_AddSearchWord t = new M211_AddSearchWord();
        t.addWord("bad");
        t.addWord("dad");
        t.addWord("mad");

        System.out.println(t.search("pad"));
        System.out.println(t.search("bad"));
        System.out.println(t.search(".ad"));
        System.out.println(t.search("b.."));
        System.out.println(t.search("b.a"));





    }
}
