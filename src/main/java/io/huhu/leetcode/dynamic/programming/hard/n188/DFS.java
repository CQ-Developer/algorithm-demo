package io.huhu.leetcode.dynamic.programming.hard.n188;

class DFS implements Solution {

    @Override
    public int maxProfit(int k, int[] prices) {
        return f(k, prices, prices.length - 1);
    }

    private int f(int k, int[] prices, int i) {
        if (k == 0 || i == -1) {
            return 0;
        }
        int ans = f(k, prices, i - 1);
        for (int j = 0; j < i; j++) {
            ans = Math.max(ans, prices[i] - prices[j] + f(k - 1, prices, j));
        }
        return ans;
    }

}
