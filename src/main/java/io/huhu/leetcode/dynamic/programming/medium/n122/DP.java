package io.huhu.leetcode.dynamic.programming.medium.n122;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }

}
