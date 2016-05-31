package com.gmail.theandriicherniak.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M271_EncodeDecodeStrings encode = new M271_EncodeDecodeStrings();
        List<String> input = new ArrayList<String>();
        input.add("aaajhsdbv");
        input.add("nndhjvsjdhfg");
        input.add("jhbjugsdfb");

        String ss = encode.encode(input);

        System.out.println(ss);

        System.out.println(encode.decode(ss));

    }
}