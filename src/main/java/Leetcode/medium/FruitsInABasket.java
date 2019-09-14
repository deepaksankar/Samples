package main.java.Leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FruitsInABasket {
    public static void main(String[] args) {
        int[] trees = {3,3,3,1,2,1,1,2,3,3,4};
        int count = totalFruit(trees);
        System.out.println(count);
    }
    static int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) {
            return 0;
        }
        int max = 1;
        Map<Integer, Integer> fruitMap = new HashMap<>();

        int j = 0; int i = 0;

        while(j < tree.length) {
            if(fruitMap.size() <= 2) {
                fruitMap.put(tree[j], j++);
            }
            if(fruitMap.size() > 2) {
                int min = tree.length - 1;
                for(int value : fruitMap.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;
                fruitMap.remove(tree[min]);
            }
            max = Math.max(max, j-i);
        }

        return max;
    }
}
