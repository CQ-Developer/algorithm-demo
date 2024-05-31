package io.huhu.leetcode.dynamic.programming.core.buy.and.sell.stock.n121;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">买卖股票的最佳时机</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        // buy 记录历史最低的买入价格
        // profit 记录历史最高的收益
        int buy = Integer.MAX_VALUE, profit = Integer.MIN_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }

}
