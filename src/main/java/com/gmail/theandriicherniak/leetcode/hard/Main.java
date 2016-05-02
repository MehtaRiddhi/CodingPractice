package com.gmail.theandriicherniak.leetcode.hard;

import java.util.*;

public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running hard examples");

        H269_AlienDictionary d = new H269_AlienDictionary();
        String[] words = new String[]{
                "a", "b", "a"
        };

        System.out.println(d.alienOrder(words));
    }
}
