package io.huhu.leetcode.dynamic.programming.hard.n123;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        int b1 = prices[0], p1 = 0;
        int b2 = -prices[0], p2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b1 = Math.min(b1, prices[i]);
            p1 = Math.max(p1, prices[i] - b1);
            b2 = Math.max(b2, p1 - prices[i]);
            p2 = Math.max(p2, b2 + prices[i]);
        }
        return p2;
    }

}
