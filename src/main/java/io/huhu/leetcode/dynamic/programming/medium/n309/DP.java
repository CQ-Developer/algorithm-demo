package io.huhu.leetcode.dynamic.programming.medium.n309;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        int free = 0, cool = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int f = free;
            free = Math.max(free, cool);
            int h = hold;
            hold = Math.max(hold, f - prices[i]);
            cool = h + prices[i];
        }
        return Math.max(free, cool);
    }

}
