package main.java.Leetcode.medium;

/**
 * Look for the longest palindromic substring within the given string
 * TC - O(n^2)
 * SC - O(1)
 */
public class LongestPalindromicSubString {
    static int low = 0, maxLen = 0;
    public static void main(String[] args) {
        String input = "babad";
        System.out.println(longestPalindrome(input));
    }

    static String longestPalindrome(String s) {
        if(s == null) {
            return null;
        }
        if(s.length() < 2) {
            return s;
        }

        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i); //assuming odd length
            extendPalindrome(s, i, i+1); //assuming even length
        }

        return s.substring(low, low+maxLen);
    }

    static void extendPalindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if(end-start-1 > maxLen) {
            maxLen = end-start-1;
            low = start+1;
        }
    }
}
