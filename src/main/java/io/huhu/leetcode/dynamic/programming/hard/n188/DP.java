package io.huhu.leetcode.dynamic.programming.hard.n188;

class DP implements Solution {

    @Override
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int l = 0; l < j; l++) {
                    dp[i][j] = Math.max(dp[i][j], prices[j] - prices[l] + dp[i - 1][l]);
                }
            }
        }
        return dp[k][n - 1];
    }

}
