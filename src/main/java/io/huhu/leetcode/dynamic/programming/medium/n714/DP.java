package io.huhu.leetcode.dynamic.programming.medium.n714;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0], free = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = hold;
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, tmp + prices[i] - fee);
        }
        return free;
    }

}
