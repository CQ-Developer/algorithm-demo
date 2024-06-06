package io.huhu.leetcode.classic.buy.and.sell.stock.n309;

/**
 * <a hre="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">买卖股票的最佳时机含冷冻期</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        int days = prices.length;
        // 持有股票的最大收益
        int[] hold = new int[days];
        hold[0] = -prices[0];
        // 不持有股票且处于冷冻期的最大收益
        int[] cold = new int[days];
        // 不持有股票且不处于冷冻期的最大收益
        int[] free = new int[days];
        // 开始计算
        for (int i = 1; i < days; i++) {
            // 持有股票的最大收益:
            // 1.之前就持有股票，不需要买卖
            // 2.之前不持有股票且不处于冷冻期可以买卖 + 买入今天股票
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            // 不持有股票且处于冷冻期的最大收益:
            // 处于冷冻期说明今天卖了股票，那么前一天必须持有股票
            cold[i] = hold[i - 1] + prices[i];
            // 不持有股票且不处于冷冻期的最大收益:
            // 1.之前就不持有股票且不处于冷冻期
            // 2.之前就不持有股票且处于冷冻期
            free[i] = Math.max(free[i - 1], cold[i - 1]);
        }
        return Math.max(cold[days - 1], free[days - 1]);
    }

}
