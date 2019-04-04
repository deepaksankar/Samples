package main.java.Leetcode.medium;

public class MaxAreaOfIslands {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1}};
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        System.out.println(maxArea);
    }

    static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        int count = grid[i][j];
        grid[i][j] = 0;

        count += dfs(grid, i, j+1);
        count += dfs(grid, i+1, j);
        count += dfs(grid, i, j-1);
        count += dfs(grid, i-1, j);

        return count;
    }
}
