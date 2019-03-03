package main.java.CTC.Strings;

/**
 * Given a string, find the longest non-repeated substring in the string
 * Sliding window problem
 */
public class NonRepeatedSubString {
    public static void main(String[] args) {
        String S = "aabcdb";
        int len = findLongestNonRepeatingString(S);
        System.out.println("Length is " + len);
    }

    static int findLongestNonRepeatingString(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int left = 0;
        int right = 0;
        int maxLeft = 0;
        int maxRight = 0;
        boolean[] table = new boolean[256];

        table[s.charAt(right)] = true;
        while(right < s.length()-1) {
            right += 1;
            if(table[s.charAt(right)] == true) {
                while (s.charAt(left) != s.charAt(right)) {
                    table[s.charAt(left)] = false;
                    left += 1;
                }
                table[s.charAt(left)] = false;
                left += 1;
            }
            table[s.charAt(right)] = true;

            if(right - left > maxRight - maxLeft) {
                maxLeft = left;
                maxRight = right;
            }
        }
        return (maxRight - maxLeft + 1);
    }
}
