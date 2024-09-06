package io.huhu.leetcode.dynamic.programming.hard.n123;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        int[] best = new int[n];
        best[0] = dp1[0] - prices[0];
        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i - 1], dp1[i] - prices[i]);
        }
        int ans = 0;
        int[] dp2 = new int[n];
        for (int i = 1; i < n; i++) {
            dp2[i] = best[i] + prices[i];
            ans = Math.max(ans, dp2[i]);
        }
        return ans;
    }

}
