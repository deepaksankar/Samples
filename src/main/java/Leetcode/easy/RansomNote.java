package main.java.Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a magazine and a ransome note, identify if all the letters from the magazine can be used to create the ransom note.
 */
public class RansomNote {
    public static void main(String[] args) {
        String magazine = "aabbbcc";
        String ransomNote = "abd";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for(Character c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }

        for(Character c : ransomNote.toCharArray()) {
            if(!charCount.containsKey(c) || charCount.get(c) <= 0) {
                return false;
            }

            charCount.put(c, charCount.get(c)-1);
        }

        return true;
    }
}
