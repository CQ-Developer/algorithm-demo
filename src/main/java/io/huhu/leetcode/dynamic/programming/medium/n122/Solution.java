package io.huhu.leetcode.dynamic.programming.medium.n122;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">买卖股票的最佳时机II</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int dif = prices[i] - prices[i - 1];
            if (dif > 0) {
                res += dif;
            }
        }
        return res;
    }

}
