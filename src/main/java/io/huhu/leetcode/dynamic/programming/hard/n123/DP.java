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
        int ans = 0;
        int[] dp2 = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp2[i] = Math.max(dp2[i], dp1[j] + prices[i] - prices[j]);
            }
            ans = Math.max(ans, dp2[i]);
        }
        return ans;
    }

}
