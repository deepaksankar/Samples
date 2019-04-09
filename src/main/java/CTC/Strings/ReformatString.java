package main.java.CTC.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string abbccb, give the output bbbcca
 * We need to use bi-directional map where we meed to get the key based on the value ans retrieve the alphabet
 * based on value
 */
public class ReformatString {
    public static void main(String[] args) {
        String in = "abbccb";

        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : in.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x, y) -> charCount.get(y)- charCount.get(x));

        maxHeap.addAll(charCount.keySet());

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            for(int i = 0; i < charCount.get(current); i++) {
                sb.append(current);
            }
        }

        System.out.println(sb.toString());
    }
}
