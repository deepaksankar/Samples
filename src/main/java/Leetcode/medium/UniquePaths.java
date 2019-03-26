package main.java.Leetcode.medium;

/**
 * Given an element starting at top left corner of a grid, find the number unique ways in which it can reach the
 * bottom right corner of the grid
 */
public class UniquePaths {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int num = numOfUniqueWays(row,col);
        System.out.println("Num of unique paths is " + num);
    }

    static int numOfUniqueWays(int row, int col) {
        if(row == 0 && col == 0) {
            return 0;
        }
        if(row == 0 || col == 0) {
            return 1;
        }

        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }

        for(int j = 0; j < col; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }
}
