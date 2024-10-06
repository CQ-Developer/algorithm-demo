package io.huhu.leetcode.n309;

class DP implements Code {

    @Override
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        // prepare[i]表示0...i范围上进行无限次交易且必须有一次购买的最大收益
        // done[i]表示0...i范围上进行无限次交易的最大收益
        int[] prepare = new int[n], done = new int[n];
        prepare[1] = Math.max(-prices[0], -prices[1]);
        done[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < n; i++) {
            done[i] = Math.max(done[i - 1], prepare[i - 1] + prices[i]);
            prepare[i] = Math.max(prepare[i - 1], done[i - 2] - prices[i]);
        }
        return done[n - 1];
    }

}
