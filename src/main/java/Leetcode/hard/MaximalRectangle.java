package main.java.Leetcode.hard;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] input = new char[][]{{'1','0','1','0','0'},{'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int ans = maximalRectangle(input);
        System.out.println(ans);
    }
    static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];

        for(int i = 0; i < rows; i++) {
            int curLeft = 0, curRight = cols;

            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for(int j = 0; j < cols; j++) {
                if(matrix[i][j]=='1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j+1;
                }
            }

            for(int j = cols-1; j >= 0; j--) {
                if(matrix[i][j]=='1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = cols;
                    curRight = j;
                }
            }

            for(int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, (right[j]-left[j])*height[j]);
            }
        }

        return maxArea;
    }
}
