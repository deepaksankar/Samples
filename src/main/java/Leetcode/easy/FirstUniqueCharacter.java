package main.java.Leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Identify the first unique character in the string
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println("First unique character is " + firstUniqueCharacter(s));
    }

    static int firstUniqueCharacter(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(!map.containsKey(current)) {
                map.put(current, i);
            } else {
                map.put(current, -1);
            }
        }
        int min = Integer.MAX_VALUE;

        for(Character c : map.keySet()) {
            if(map.get(c) > -1 && map.get(c) < min) {
                min = map.get(c);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
