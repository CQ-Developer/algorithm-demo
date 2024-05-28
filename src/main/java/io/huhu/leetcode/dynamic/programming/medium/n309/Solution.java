package io.huhu.leetcode.dynamic.programming.medium.n309;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">买卖股票的最佳时机含冷冻期</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 本质上只需要3对三个状态
        int dp0 = -prices[0], dp1 = 0, dp2 = 0;
        for (int i = 1; i < n; i++) {
            // dp0: 手上持有股票的最大收益
            // dp1: 手上不持有股票，并且处于冷冻期中的累计最大收益
            // dp2: 手上不持有股票，并且不在冷冻期中的累计最大收益
            int t0 = Math.max(dp0, dp2 - prices[i]);
            int t1 = dp0 + prices[i];
            int t2 = Math.max(dp1, dp2);
            dp0 = t0;
            dp1 = t1;
            dp2 = t2;
        }
        return Math.max(dp1, dp2);
    }

}
