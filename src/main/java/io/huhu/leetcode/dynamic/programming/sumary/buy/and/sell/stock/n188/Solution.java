package io.huhu.leetcode.dynamic.programming.sumary.buy.and.sell.stock.n188;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">买卖股票的最佳时机IV</a>
 */
class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // n天最多只能执行n/2次交易
        k = Math.min(k, n >> 1) + 1;
        // hold[i]表示第i次交易时，持有股票的最大收益
        // free[i]表示第i次交易时，不持有股票的最大收益
        int[] hold = new int[k], free = new int[k];
        Arrays.fill(hold, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i < k; i++) {
                hold[i] = Math.max(hold[i], free[i - 1] - price);
                free[i] = Math.max(free[i], hold[i] + price);
            }
        }
        return free[k - 1];
    }

}
