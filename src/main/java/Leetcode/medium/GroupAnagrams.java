package main.java.Leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> groupedAna = new ArrayList<>();

        Map<String, List<String>> mapping = new LinkedHashMap<>();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        

        for (String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String sorted = new String(chars);

            if (!mapping.containsKey(sorted)) {
                mapping.put(sorted, new ArrayList<>());
            }

            mapping.get(sorted).add(str);
        }
        groupedAna.addAll(mapping.values());
    }
}
