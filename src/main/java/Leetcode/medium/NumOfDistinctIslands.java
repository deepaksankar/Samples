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
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    StringBuilder sb = new StringBuilder();
                    helper(grid, row, col, 0, 0, sb);
                    String s = sb.toString();
                    if(!set.contains(s)) {
                        result += 1;
                        set.add(s);
                    }

                }
            }
        }
        return result;
    }

    static void helper(int[][] grid, int row, int col, int xpos, int ypos, StringBuilder sb) {
        grid[row][col] = 0;
        sb.append(xpos + "" + ypos);
        for(int[] dir : dirs) {
            int x = row+dir[0];
            int y = col+dir[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[row].length || grid[x][y] == 0) {
                continue;
            }
            helper(grid, x, y, xpos+dir[0], ypos+dir[1], sb);
        }
    }
}
