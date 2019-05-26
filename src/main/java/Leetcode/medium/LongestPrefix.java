package main.java.Leetcode.medium;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] in = {"flight", "float", "flow"};
        String out = longestCommonPrefix(in);
        System.out.println(out);
    }

    static String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        if(strs == null || strs.length == 0) {
            return longestCommonPrefix;
        }
        int index = 0;
        for(Character c : strs[0].toCharArray()) {
            for(int i = 1; i < strs.length; i++) {
                if(index >= strs[i].length() || strs[i].charAt(index) != c) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += c;
            index++;
        }

        return longestCommonPrefix;
    }
}
