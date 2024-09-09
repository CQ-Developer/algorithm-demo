package io.huhu.leetcode.dynamic.programming.medium.n309;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int pre = Math.max(-prices[0], -prices[1]), cur = Math.max(0, prices[1] - prices[0]), preCur = 0;
        for (int i = 2; i < prices.length; i++) {
            int tmp = Math.max(cur, pre + prices[i]);
            pre = Math.max(pre, preCur - prices[i]);
            preCur = cur;
            cur = tmp;
        }
        return cur;
    }

}
