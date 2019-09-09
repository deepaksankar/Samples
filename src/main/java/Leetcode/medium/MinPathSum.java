package main.java.Leetcode.medium;

/**
 * Finding the minimum cost to reach the bottom right of a matrix from top left corner.
 * TC - O(n*m)
 * SC - O(n*m)
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,2},
                        {5,6},
                        {1,1}};
        int minDistance = minSum(grid);
        System.out.println(minDistance);
    }

    static int minSum(int[][] grid) {
        if(grid == null || grid.length == 0)  {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if(j > 0) {
                    dp[i][j] += dp[i][j-1];
                } else if (i > 0){
                    dp[i][j] += dp[i-1][j];
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
