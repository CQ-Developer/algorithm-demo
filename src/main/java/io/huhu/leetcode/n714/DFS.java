package io.huhu.leetcode.n714;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int maxProfit(int[] prices, int fee) {
        int[][] m = new int[prices.length][2];
        for (int[] a : m) {
            Arrays.fill(a, -1);
        }
        return f(prices, fee, 0, 0, m);
    }

    private int f(int[] prices, int fee, int i, int j, int[][] m) {
        if (i == prices.length) {
            return 0;
        }
        if (m[i][j] != -1) {
            return m[i][j];
        }
        int ans = f(prices, fee, i + 1, j, m);
        if (j == 1) {
            ans = Math.max(ans, f(prices, fee, i + 1, 0, m) + prices[i] - fee);
        } else {
            ans = Math.max(ans, f(prices, fee, i + 1, 1, m) - prices[i]);
        }
        return m[i][j] = ans;
    }

}
