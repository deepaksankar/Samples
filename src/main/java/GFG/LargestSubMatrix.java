package main.java.GFG;

/**
 * Given a matrix of 1's and 0's, find the largest sub matrix that only contains 1
 */
public class LargestSubMatrix {
    public static void main(String[] args) {
        int[][] input = {{0, 1, 1, 0, 1}, {1, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};
        printSubMatrix(input);
    }

    static void printSubMatrix(int[][] input) {
        int R = input.length;
        int C = input[0].length;

        int[][] S = new int[R][C];

        int i, j;

        for(i = 0; i < R; i++) {
            S[i][0] = input[i][0];
        }

        for(j=0; j < C; j++) {
            S[0][j] = input[0][j];
        }

        for(i = 1; i < R; i++) {
            for(j = 1; j < C; j++) {
                if(input[i][j] == 1) {
                    S[i][j] = Math.min(S[i][j-1], Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                } else {
                    S[i][j] = 0;
                }
            }
        }

        int max_Of_S = S[0][0], maxI = 0, maxJ = 0;

        for(i = 0; i < R; i++) {
            for(j = 0; j < C; j++) {
                if(max_Of_S < S[i][j]) {
                    max_Of_S = S[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        for(i = maxI; i > maxI-max_Of_S; i--) {
            for(j = maxJ; j > maxJ-max_Of_S; j--) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
