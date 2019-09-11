package main.java.Leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumOfDistinctIslands {
    static int[][] dirs= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0}, {1,1,0,0}, {0,0,1,1}, {0,0,1,1}};
        int islandCount = numDistinctIslands(grid);
        System.out.println(islandCount);
    }
    static int numDistinctIslands(int[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0) {
            return 0;
        }
        Set<String> pattern = new HashSet<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, row, col, sb, "o");
                    grid[row][col] = 0;
                    pattern.add(sb.toString());
                }
            }
        }
        return pattern.size();
    }

    static void dfs(int[][] grid, int row, int col, StringBuilder sb, String dir) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return;
        }
        sb.append(dir);
        grid[row][col] = 0;
        dfs(grid, row-1, col, sb, "u");
        dfs(grid, row+1, col, sb, "d");
        dfs(grid, row, col-1, sb, "l");
        dfs(grid, row, col+1, sb, "r");
        sb.append("b");
    }
}
