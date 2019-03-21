package main.java.Leetcode.easy;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {1, 5, 4, 2, 7, 1};
        System.out.println("Max profit is " + maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i]-min);
            }
        }
        return max;
    }
}
