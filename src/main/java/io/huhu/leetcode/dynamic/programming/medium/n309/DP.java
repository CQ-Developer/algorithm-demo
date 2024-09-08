package io.huhu.leetcode.dynamic.programming.medium.n309;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] free = new int[n], cool = new int[n], hold = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            cool[i] = hold[i - 1] + prices[i];
            free[i] = Math.max(free[i - 1], cool[i - 1]);
        }
        return Math.max(free[n - 1], cool[n - 1]);
    }

}
