package main.java.Leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Identify how long would it take for a oranges in a field to rot.
 */
public class RottenOranges {
    public static void main(String[] args) {
        int[][] oranges = new int[][]{{2,1,1}, {0,1,1}, {0,1,1}};
        int numOfminutes = orangesRotting(oranges);
        System.out.println(numOfminutes);
    }

    static int orangesRotting(int[][] oranges) {
        if(oranges == null || oranges.length == 0) {
            return 0;
        }
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        int rows = oranges.length;
        int cols = oranges[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(oranges[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if(oranges[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }
        int count = 0;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            ++count;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    // Checking for out of bounds, no oranges and already rotten oranges, do nothing in all cases.
                    if(x < 0 || x >= rows || y < 0 || y >= cols || oranges[x][y] == 0 || oranges[x][y] == 2) {
                        continue;
                    }
                    oranges[x][y] = 2;
                    q.add(new int[]{x, y});
                    freshOranges--;
                }
            }
        }

        return freshOranges == 0 ? count-1 : -1;
    }
}
