package main.java.Leetcode.medium;

/**
 * Given an array of string, replace the consecutive characters with the character and its count.
 * Doing it in place in memory.
 */
public class StringCompressionII {
    public static void main(String[] args) {
        char[] input = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int ans = compress(input);
        System.out.println(ans);
    }
    static int compress(char[] chars) {
        if(chars == null || chars.length <= 1) {
            return 0;
        }
        int count = 0;
        int index = 0;
        int indexAns = 0;
        while(index < chars.length) {
            char current = chars[index];
            count = 0;
            while(index < chars.length && chars[index] == current) {
                index++;
                count++;
            }
            chars[indexAns++] = current;
            if(count != 1) {
                for(char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }

        return indexAns;
    }
}
