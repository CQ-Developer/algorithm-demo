package io.huhu.leetcode.n122;

class DP implements Code {

    @Override
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(prices[i] - prices[i - 1], 0) + dp[i - 1];
        }
        return dp[n - 1];
    }

}
