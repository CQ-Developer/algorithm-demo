package io.huhu.leetcode.n122;

class DFS implements Code {

    @Override
    public int maxProfit(int[] prices) {
        return f(prices, 1);
    }

    private int f(int[] prices, int i) {
        if (i == prices.length) {
            return 0;
        }
        return Math.max(prices[i] - prices[i - 1], 0) + f(prices, i + 1);
    }

}
