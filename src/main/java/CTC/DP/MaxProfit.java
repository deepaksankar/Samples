package main.java.CTC.DP;

public class MaxProfit {
    public static void main(String[] args) {
//        int[] input = {1, 2, 4, 7, 11, 16, 21, 27, 34, 42};
//        int[] input = {2, 5, 7, 1, 4, 3, 1, 3};
        int[] input = {40, 30, 20, 15, 12, 10, 5, 1};
        int maxPrfit = maxProfit(input, 1);
        System.out.println(maxPrfit);
    }

    static int maxProfit(int[] stockPrices, int n) {
        int[][] dp = new int[n+1][stockPrices.length];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int j = 0; j < stockPrices.length; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            int maxDiff = -stockPrices[0];
            for (int j = 1; j < stockPrices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], stockPrices[j] + maxDiff);
                if (dp[i-1][j] != Integer.MIN_VALUE) {
                    maxDiff = Math.max(maxDiff, dp[i - 1][j] - stockPrices[j]);
                } else {
                    maxDiff = Math.max(maxDiff, 0 - stockPrices[j]);
                }
            }
        }
        return dp[n][stockPrices.length-1];
    }
}
