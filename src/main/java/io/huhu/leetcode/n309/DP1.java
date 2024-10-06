package io.huhu.leetcode.n309;

class DP1 implements Code {

    @Override
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int prepare = Math.max(-prices[0], -prices[1]);
        int done1 = 0, done2 = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            int cur = Math.max(done2, prepare + prices[i]);
            prepare = Math.max(prepare, done1 - prices[i]);
            done1 = done2;
            done2 = cur;
        }
        return done2;
    }

}
