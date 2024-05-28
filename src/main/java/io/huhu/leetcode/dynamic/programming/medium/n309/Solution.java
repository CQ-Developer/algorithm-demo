package io.huhu.leetcode.dynamic.programming.medium.n309;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">买卖股票的最佳时机含冷冻期</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean freeze = false;
        int[] dp = new int[prices.length];
        for (int i = 1; i < dp.length; i++) {
            if (freeze) {
                freeze = false;
                continue;
            }
            if (prices[i] > prices[i - 1]) {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
                profit += dp[i];
                freeze = true;
            }
        }
        return profit;
    }

}
