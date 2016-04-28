package com.gmail.theandriicherniak.leetcode.hard;

public class Main {
    public static void main(java.lang.String[] args){
        System.out.println("running hard examples");

        H146_LRUCache cache = new H146_LRUCache(3);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.set(5,5);

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));


    }
}
