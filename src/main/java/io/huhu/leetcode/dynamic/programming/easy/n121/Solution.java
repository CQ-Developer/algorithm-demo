package io.huhu.leetcode.dynamic.programming.easy.n121;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">买卖股票的最佳时机</a>
 */
class Solution {

    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {
        int cost = 10001, profit = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

}
