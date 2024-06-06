package io.huhu.leetcode.classic.buy.and.sell.stock.n122;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">买卖股票的最佳时机II</a>
 */
class Solution {

    /**
     * 题意是每天必须选择买或者卖
     */
    public int maxProfit(int[] prices) {
        // 核心思想：只要能赚钱就买卖
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

}
