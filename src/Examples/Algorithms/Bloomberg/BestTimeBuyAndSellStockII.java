package Examples.Algorithms.Bloomberg;

/*
Best Time to Buy and Sell Stock (Easy)
Allow multiple buy in and sell
 */

public class BestTimeBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }


    // Second way


    /*
    public int maxProfit(int[] prices) {
        int sum = 0;
        if (prices.length == 0)
            return sum;

        int buy = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] < prices[buy])
                buy = i;
            else {
                sum = sum + prices[i] - prices[buy];
                buy = i;
            }
        }
        return sum;
    }
     */
}
