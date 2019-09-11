package main.java.Leetcode.medium;

/**
 * Given an array of string, replace the consecutive characters with the character and its count.
 * Doing it, not in the same memory.
 */
public class StringCompression {
    public static void main(String[] args) {
        char[] input = new char[] {'a','a','b','b','c','c','c'};
        int newLen = compress(input);
        System.out.println(newLen);
    }
    static int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }
        int count = 0;
        char[] out = new char[chars.length];
        int index = 0;
        for(int i = 0; i < chars.length-1; i++) {
            if(chars[i] == chars[i+1]) {
                count++;
            } else {
                out[index++] = chars[i];
                out[index++] = (char)(count+'0'); //converting int to char
                count = 0;
            }
        }
        if(count > 0) {
            out[index++] = chars[chars.length-1];
            out[index++] = (char)(count+'0');
            count = 0;
        }

        return index;
    }
}
