package Examples.Algorithms.Greedy;

/*
Best Time to Buy and Sell Stock (Easy)
One time buy and sell
 */

public class BestTimeBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (soFarMin > prices[i])
                soFarMin = prices[i];
            else
                max = Math.max(max, prices[i] - soFarMin);
        }
        return max;
    }
}
