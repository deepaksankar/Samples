package main.java.Leetcode.medium;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and list of banned words, find the most common word in the paragraph that is not in the
 * list of banned words
 */
public class BannedWords {
    public static void main(String[] args) {
        String paragraph = "This is a sample para to determine the most common word that is not been banned by engineers";
        String[] bannedWords = {"a", "to", "most"};

        Set<String> banned = new LinkedHashSet<>();
        for (String word : bannedWords) {
            banned.add(word);
        }

        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : paragraph.replaceAll("[^A-Za-z]", " ").toLowerCase().split(" ")) {
            if (!banned.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        for (String key : counts.keySet()) {
            if(result.equals("") || counts.get(key) > counts.get(result)) {
                result = key;
            }
        }

        System.out.println("Common word is " + result);
    }
}
