package main.java.Leetcode.medium;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the
 * grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumOfIslands {
    public static void main(String[] args) {
        System.out.println("Done");
    }
    static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int numOfIslands = 0;

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == '1') {
                    numOfIslands += dfs(grid, row, col);
                }
            }
        }

        return numOfIslands;
    }

    static int dfs(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return 0;
        }

        grid[row][col] = '0';
        dfs(grid, row, col+1);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row-1, col);

        return 1;
    }
}
