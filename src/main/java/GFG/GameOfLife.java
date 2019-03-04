package main.java.GFG;

/**
 * Conway's game of life
 * Initially, there is a grid with some cells which may be alive or dead. Our task to generate the next generation
 * of cells based on the following rules:
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] currentGen = {{0, 1, 1, 0}, {0, 1, 0, 1}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        printNextGen(currentGen, currentGen.length, currentGen[0].length);
    }

    static void printNextGen(int[][] currentGen, int rows, int cols) {
        int[][] nextGen = computeNextGen(currentGen, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(nextGen[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int[][] computeNextGen(int[][] currentGen, int rows, int cols) {
        int[][] nextGen = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighboringSum = neighborsWeight(currentGen, i, j, rows, cols);

                if (currentGen[i][j] == 1 && neighboringSum < 2) {
                    nextGen[i][j] = 0;
                }
                else if (currentGen[i][j] == 1 && neighboringSum > 3) {
                    nextGen[i][j] = 0;
                }
                else if (currentGen[i][j] == 0 && neighboringSum == 3) {
                    nextGen[i][j] = 1;
                }
                else {
                    nextGen[i][j] = currentGen[i][j];
                }
            }
        }
        return nextGen;
    }

    static int neighborsWeight(int[][] currentGen, int row, int col, int rows, int cols) {
        int sum = 0;
        for (int i = Math.max(0, row-1); i <= Math.min(rows-1, row+1); i++) {
            for (int j = Math.max(0, col-1); j <= Math.min(cols-1, col+1); j++) {
                sum += currentGen[i][j];
            }
        }

        return (sum-currentGen[row][col]);
    }
}
