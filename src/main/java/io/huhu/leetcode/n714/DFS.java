package io.huhu.leetcode.n714;

class DFS implements Code {

    @Override
    public int maxProfit(int[] prices, int fee) {
        return f(prices, fee, 0, 0);
    }

    private int f(int[] prices, int fee, int i, int hold) {
        if (i == prices.length) {
            return 0;
        }
        int a = f(prices, fee, i + 1, hold);
        if (hold == 1) {
            a = Math.max(a, f(prices, fee, i + 1, 0) + prices[i] - fee);
        } else {
            a = Math.max(a, f(prices, fee, i + 1, 1) - prices[i]);
        }
        return a;
    }

}
