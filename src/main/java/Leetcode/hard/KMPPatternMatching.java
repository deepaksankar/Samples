package main.java.Leetcode.hard;

public class KMPPatternMatching {
    public static void main(String[] args) {
        String input = "abxabcabcaby";
        String pattern = "abcaby";

    }

    static boolean KMP(char[] text, char[] pattern) {
        int[] lps = tempCharPatternMatch(pattern);
        int i = 0; int j = 0;
        while(i < text.length && j < pattern.length) {
            if(text[i] == pattern[j]) {
                i++;j++;
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return j == pattern.length ? true:false;
    }

    static int[] tempCharPatternMatch(char[] pattern) {
        int[] result = new int[pattern.length];
        int index = 0;
        for(int i = 1; i < pattern.length;) {
            if(pattern[i] == pattern[index]) {
                result[i] = index+1;
                i++;
                index++;
            } else {
                if(index != 0) {
                    index = result[index-1];
                } else {
                    result[i] = 0;
                    i++;
                }
            }
        }
    }
}
