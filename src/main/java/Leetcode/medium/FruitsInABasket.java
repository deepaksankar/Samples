package main.java.Leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class FruitsInABasket {
    public static void main(String[] args) {
        int[] trees = {};

        if(trees == null || trees.length == 0) {
            return;
        }

        int max = 1;

        Map<Integer, Integer> mapping = new LinkedHashMap<>();
        int start = 0;
        int current = 0;

        while (current < trees.length) {
            if(mapping.size() <= 2) {
                mapping.put(trees[current], current++);
            }

            if(mapping.size() > 2) {
                int min = trees.length-1;

                for (int value : mapping.values()) {
                    min = Math.min(min, value);
                }
                start = min + 1;
                mapping.remove(trees[min]);
            }
            max = Math.max(max, current-start);
        }
    }
}
