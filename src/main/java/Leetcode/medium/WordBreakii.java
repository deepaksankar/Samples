package main.java.Leetcode.medium;

import java.util.*;

public class WordBreakii {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] words = {"cats", "and", "sand", "dog"};
        Set<String> wordSet = new LinkedHashSet<>();

        for (String word : words) {
            wordSet.add(word);
        }

        List<String> output = dfs(s, wordSet, new HashMap<>());
        System.out.println("Done");
    }

    static List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new LinkedList<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordSet) {
            if(s.startsWith(word)) {
                List<String> subStr = dfs(s.substring(word.length()), wordSet, map);
                for (String s1 : subStr) {
                    res.add(word + (s1.isEmpty() ? "" : " " + s1));
                }
            }
        }
        map.put(s, res);

        return res;
    }
}
