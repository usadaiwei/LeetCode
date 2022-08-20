package Examples.Algorithms.Bloomberg;
/*
518. Coin Change 2
Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins){
            for (int i = coin; i < amount + 1; i++){    // i = coin因为如果amount小于coin, 方式肯定不会变多
                dp[i] += dp[i-coin];
            }
        }

        return dp[amount];
    }
}
