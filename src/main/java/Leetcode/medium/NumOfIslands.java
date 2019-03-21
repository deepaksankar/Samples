package main.java.Leetcode.medium;

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
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);

        return 1;
    }
}
