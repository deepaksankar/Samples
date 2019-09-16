package main.java.AtoZ;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Amazon interview question
 */
public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] input = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output = sortLogs(input);
        System.out.println(output);
    }

    static String[] sortLogs(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si+1);
                char s2fc = s2.charAt(s2si+1);

                if (s1fc <= '9') {
                    if (s2fc <= '9') {
                        return 0;
                    }
                    else {
                        return 1;
                    }
                }
                if (s2fc <= '9') {
                    return -1;
                }

                int compareValue = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
                if (compareValue == 0) {
                    return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                }
                return compareValue;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
