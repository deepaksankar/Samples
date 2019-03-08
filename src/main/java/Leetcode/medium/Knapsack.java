package main.java.Leetcode.medium;

/**
 * Given clocks with weight and value, find the maximum value of clocks that can be picked with the given knapsack
 * that can only hold certain weight
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] prices = {35, 45, 20, 100, 45, 50, 30};
        int[] weights = {8, 12, 9, 15, 6, 8, 6};
        int capacity = 24;

        int nap = knapSack(capacity, weights, prices, prices.length);

        System.out.println("Value is " + nap);
    }

    static int knapSack(int W, int[] wts, int[] val, int n) {
        int i, w;
        int[][] K = new int[n+1][W+1];

        for (i= 0; i <= n; i++) {
            for ( w = 0; w <= W; w++) {
                if ( i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wts[i-1] <= w) {
                    K[i][w] = Math.max(val[i-1]+ K[i-1][w-wts[i-1]], K[i-1][w]);
                } else {
                    K[i][w] = K[i-1][w];
                }
            }
        }

        return K[n][W];
    }
}
