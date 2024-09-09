package io.huhu.leetcode.dynamic.programming.medium.n714;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices, int fee) {
        int prepare = -prices[0] - fee, done = 0;
        for (int i = 1; i < prices.length; i++) {
            done = Math.max(done, prepare + prices[i]);
            prepare = Math.max(prepare, done - prices[i] - fee);
        }
        return done;
    }

}
