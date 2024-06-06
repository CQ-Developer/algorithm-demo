package io.huhu.leetcode.classic.buy.and.sell.stock.n123;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/">买卖股票的最佳时机III</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        /* 在任意一天结束后可能处于一下5种状态
         * 1. 未进行过任何交易(忽略)
         * 2.只进行过一次买操作
         * 3.进行了一次买操作和卖操作，即完成了一笔交易
         * 4.在进行了一次交易的前提下，进行了第二次买操作
         * 5.完成了全部两笔交易
         *
         * 记录上述4种状态的最大利润：
         * buy1 sell1 buy2 sell2
         *
         * 第i-1天的四种状态 -> 第i天的四种状态
         *
         * 状态转换：
         * 第i天可以不进行任何操作，或买入
         * buy1[i] = max(buy1[i-1], -prices[i])
         * 第i天可以进行任何操作，或在进行过一次买入前提下卖出
         * sell1[i] = max(sell1[i-1], buy1[i-1]+prices[i])
         * 对于buy2和sell2同理
         * buy2[i] = max(buy2[i-1], sell1[i-1]-prices[i])
         * sell2[i] = max(sell2[i-1], buy2[i-1]+prices[i])
         */
        int n = prices.length;
        int b1 = -prices[0], s1 = 0;
        int b2 = -prices[0], s2 = 0;
        for (int i = 1; i < n; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }
        return s2;
    }

}
