package io.huhu.leetcode.dynamic.programming.core.buy.and.sell.stock.n714;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">买卖股票的最佳时机含手续费</a>
 */
class Solution {

    public int maxProfit(int[] prices, int fee) {
        int free = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int _hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, hold + prices[i] - fee);
            hold = _hold;
        }
        return free;
    }

}
