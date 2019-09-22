package main.java.Leetcode.medium;

/**
 * Given a m*n matrix, identify the minimum falling path sum in the matrix.
 */
public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int min = minFallingSum(grid);
        System.out.println(min);
    }
    static int minFallingSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }
        for(int i = 1; i < m; i++) {
            for(int k = 0; k < n; k++) {
                dp[i][k] = dp[i-1][k] + grid[i][k];
                if(k > 0) {
                    dp[i][k] = Math.min(dp[i][k], dp[i-1][k-1]+grid[i][k]);
                }
                if(k < grid[i].length-1) {
                    dp[i][k] = Math.min(dp[i][k], dp[i-1][k+1]+grid[i][k]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            min = Math.min(min, dp[m-1][j]);
        }
        return min;
    }
}
