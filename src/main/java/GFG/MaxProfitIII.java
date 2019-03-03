package main.java.GFG;

/**
 * Find the max profit with at most two transactions
 * Buy -> Sell, Buy -> Sell
 */
public class MaxProfitIII {
    public static void main(String[] args) {
        int[] stockprices = {2,5,1,2,1,8,5,11,3};
        int maxProfit = maxProfit(stockprices);
        System.out.println("Max profit is " + maxProfit);
    }

    static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = 0;
        }
        int max_price = prices[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (prices[i] > max_price) {
                max_price = prices[i];
            }
            profit[i] = Math.max(profit[i+1], max_price-prices[i]);
        }

        int min_price = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            profit[i] = Math.max(profit[i-1], profit[i] + (prices[i]-min_price));
        }
        return profit[n-1];
    }
}
