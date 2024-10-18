package io.huhu.leetcode.n714;

class DP implements Code {

    @Override
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0], free = 0;
        for (int i = 1; i < prices.length; i++) {
            int _free = free;
            free = Math.max(free, hold + prices[i] - fee);
            hold = Math.max(hold, _free - prices[i]);
        }
        return free;
    }

}
