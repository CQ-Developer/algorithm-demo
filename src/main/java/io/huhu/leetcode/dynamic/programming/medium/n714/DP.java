package io.huhu.leetcode.dynamic.programming.medium.n714;

class DP implements Solution {

    @Override
    public int maxProfit(int[] prices, int fee) {
        int sold = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = sold;
            sold = Math.max(sold, hold + prices[i] - fee);
            hold = Math.max(hold, tmp - prices[i]);
        }
        return sold;
    }

}
