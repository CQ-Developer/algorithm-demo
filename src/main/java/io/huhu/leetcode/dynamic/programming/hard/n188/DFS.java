package io.huhu.leetcode.dynamic.programming.hard.n188;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(k, prices, n - 1, dp);
    }

    private int f(int k, int[] prices, int i, int[][] dp) {
        if (k == 0 || i < 0) {
            return 0;
        }
        if (dp[k][i] != -1) {
            return dp[k][i];
        }
        int ans = f(k, prices, i - 1, dp);
        for (int j = 0; j < i; j++) {
            ans = Math.max(ans, prices[i] - prices[j] + f(k - 1, prices, j, dp));
        }
        return dp[k][i] = ans;
    }

}
