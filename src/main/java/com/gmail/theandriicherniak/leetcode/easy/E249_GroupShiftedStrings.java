package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 2/12/16.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class E249_GroupShiftedStrings {

    private String string_signature(String word){
        int mod = 'z'-'a' + 1;

        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++){
            sb.append('#');
            sb.append(((chars[i] - chars[0]) + mod) % mod);
        }
        return sb.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groups = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> indexes = new HashMap<String, ArrayList<String>>();

        if (strings == null) return groups;

        for (String word : strings){
            String signature = string_signature(word);
            System.out.println(word + " " + signature);

            if (!indexes.containsKey(signature)) indexes.put(signature, new ArrayList<String>());
            indexes.get(signature).add(word);
        }

        for (ArrayList<String> v : indexes.values()){
            Collections.sort(v);
            groups.add(v);
        }

        return groups;
    }
}
