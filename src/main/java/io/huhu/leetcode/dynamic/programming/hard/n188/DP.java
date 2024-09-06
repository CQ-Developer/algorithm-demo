package io.huhu.leetcode.dynamic.programming.hard.n188;

class DP implements Solution {

    @Override
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= (n >> 1)) {
            return infinity(prices);
        }
        int[] dp = new int[n];
        for (int i = 0; i < k; i++) {
            int best = dp[0] - prices[0];
            for (int j = 1; j < n; j++) {
                int tmp = dp[j];
                dp[j] = Math.max(dp[j - 1], best + prices[j]);
                best = Math.max(best, tmp - prices[j]);
            }
        }
        return dp[n - 1];
    }

    /**
     * 相当于可以进行无限制次数的交易
     */
    private int infinity(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
