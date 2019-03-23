package main.java.Leetcode.medium;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Find the next closest time to the given time having only the same digits as the input.
 */
public class NextClosestTime {
    public static void main(String[] args) {
        String time = "19:34";
        System.out.println("Closest time is " + nextClosest(time));
    }

    static String nextClosest(String time) {
        if(time.length() < 5) {
            return "Invalid time format";
        }

        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
        minutes += Integer.parseInt(time.substring(3));

        Set<Integer> digits = new LinkedHashSet<>();

        for(char c : time.toCharArray()) {
            digits.add(c - '0');
        }

        while(true) {
            boolean isValid = true;
            minutes = (minutes + 1) % (24 * 60);
            int[] nextTime = {minutes/60/10, minutes/60%10, minutes%60/10, minutes%60%10};

            for(int digit : nextTime) {
                if(!digits.contains(digit)) {
                    isValid = false;
                }
            }

            if(isValid) {
                return String.format("%02d:%02d", minutes/60, minutes%60);
            }
        }
    }
}
