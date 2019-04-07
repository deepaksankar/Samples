package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2d matrix, print it in spiral manner from the given start point
 */
public class SpiralMatrix {
    public static void main(String[] args) {

    }

    static int[][] printMatrix(int R, int C, int r0, int c0) {
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        List<int[]> result = new ArrayList<>();
        int dir = 0;
        int len = 0;
        result.add(new int[]{r0,c0});

        while(result.size() < R*C) {
            if(dir == 0 || dir == 2) {
                len++;
            }
            for(int i = 0; i < len; i++) {
                r0 += directions[dir][0];
                c0 += directions[dir][1];

                if(checkWithinBoundary(R, C, r0, c0)) {
                    result.add(new int[]{r0, c0});
                }
            }
            dir = (dir+1)%4;
        }
        return result.toArray(new int[R * C][2]);
    }

    static boolean checkWithinBoundary(int R, int C, int r0, int c0) {
        return (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C);
    }
}
