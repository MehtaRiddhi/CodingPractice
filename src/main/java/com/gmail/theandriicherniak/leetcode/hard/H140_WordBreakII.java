package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/29/16.
 */
import java.util.*;

public class H140_WordBreakII {
    HashMap<String, List<String>> buffer = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, Set<String> wordDict) {

        List<String> result = new ArrayList<String>();
        if (s.isEmpty()) return result;
        if (buffer.containsKey(s)) return buffer.get(s);

        for (int i = 1; i <= s.length(); i++){
            String ss = s.substring(0, i);

            if (wordDict.contains(ss)){
                List<String> rest = wordBreak(s.substring(i), wordDict);

                if (rest.isEmpty()){
                    if (i == s.length()) result.add(ss);
                }else {
                    for(String str : rest) result.add(ss + " " + str);
                }
            }
        }
        buffer.put(s, result);

        return result;
    }
}
