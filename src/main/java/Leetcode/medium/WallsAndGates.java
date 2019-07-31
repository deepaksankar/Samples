package main.java.Leetcode.medium;

/**
 * Find the shortest distance from the gate to the empty room
 * 0 - gate
 * -1 - wall
 * 10 - an empty room
 */
public class WallsAndGates {
    public static void main(String[] args) {
        int[][] inputGrid = {{10, -1, 0, 10}, {10, 10, 10, -1}, {10, -1, 10, -1}, {0, -1, 10, 10}};
        calculateDistance(inputGrid);
        System.out.println("Done");
    }

    static void calculateDistance(int[][] input) {
        for(int row = 0; row < input.length; row++) {
            for(int col = 0; col < input[row].length; col++) {
                if(input[row][col] == 0) {
                    minimumDistanceHelper(input, row, col, 0);
                }
            }
        }
    }

    static void minimumDistanceHelper(int[][] input, int row, int col, int dist) {
        //do boundary checking
        if(row < 0 || row >= input.length || col < 0 || col >= input[row].length || input[row][col] < dist) {
            return;
        }
        input[row][col] = dist;
        minimumDistanceHelper(input, row, col+1, dist+1);
        minimumDistanceHelper(input, row+1, col, dist+1);
        minimumDistanceHelper(input, row, col-1, dist+1);
        minimumDistanceHelper(input, row-1, col, dist+1);
    }

}
