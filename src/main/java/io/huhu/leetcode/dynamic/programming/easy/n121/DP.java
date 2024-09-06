package io.huhu.leetcode.dynamic.programming.easy.n121;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

}
