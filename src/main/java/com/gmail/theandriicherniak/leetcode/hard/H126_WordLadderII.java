package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 6/1/16.
 */
import java.util.*;

public class H126_WordLadderII {
    private HashSet<String> helper(int wL, HashSet<String> input, Set<String> wordList, HashMap<String, List<List<String>>> dp){
        HashSet<String> output = new HashSet<String>();

        StringBuilder sb = new StringBuilder();
        for (String word : input){
            sb.setLength(0);
            sb.append(word);

            for (int pos = 0; pos < wL; pos++){
                for (char ch = 'a'; ch <= 'z'; ch++){
                    sb.setCharAt(pos, ch);
                    String ss = sb.toString();

                    if (wordList.contains(ss)){

                        output.add(ss);
                        if (!dp.containsKey(ss)) dp.put(ss, new ArrayList<List<String>>());
                        for (List<String> ll : dp.get(word)){
                            ArrayList<String> llc = new ArrayList<String>(ll);
                            llc.add(ss);
                            dp.get(ss).add(llc);
                        }
                    }
                }

                sb.setCharAt(pos, word.charAt(pos));
            }
        }

        return output;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        int wL = beginWord.length();
        wordList.add(endWord);
        wordList.remove(beginWord);
        int L = wordList.size();

        if (L == 0) return result;

        HashMap<String, List<List<String>>> dp = new HashMap<String, List<List<String>>>();
        dp.put(beginWord, new ArrayList<List<String>>());
        ArrayList<String> ssL = new ArrayList<String>();

        ssL.add(beginWord);
        dp.get(beginWord).add(ssL);

        HashSet<String> input = new HashSet<String>();
        input.add(beginWord);

        int iter = 0;

        while (iter < L && !dp.containsKey(endWord)){
            HashSet<String> output = helper(wL, input, wordList, dp);
            for (String word : output) wordList.remove(word);

            input = output;
            iter ++;
        }

        if (dp.containsKey(endWord)) return dp.get(endWord);

        return result;
    }
}