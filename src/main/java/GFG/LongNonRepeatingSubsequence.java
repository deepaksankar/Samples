package main.java.GFG;

/**
 * Find the length of the longest non repeating subsequence in the given string.
 */
public class LongNonRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int len = longestNonRepeatingSubSequence(s);
        System.out.println("Longest non repeating sub string is " + len);
    }

    static int longestNonRepeatingSubSequence(String s) {
        int n = s.length();
        int maxLen = 1;
        int curLen = 1;
        int prevInd;
        int i;
        int[] visited = new int[256]; //total number of ascii characters
        for(i = 0; i < 256; i++) {
            visited[i] = -1;
        }
        visited[s.charAt(0)] = 0;
        for(i = 1; i < n; i++) {
            prevInd = visited[s.charAt(i)];
            if(prevInd == -1 || i - curLen > prevInd) {
                curLen += 1;
            }
            else {
                if(curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = i - prevInd;
            }
            visited[s.charAt(i)] = i;
        }
        if(curLen > maxLen)
            maxLen = curLen;
        return maxLen;
    }

}
