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
        int ans;
        if (j == 1) {
            ans = Math.max(f(prices, fee, i + 1, j, m), f(prices, fee, i + 1, 0, m) + prices[i] - fee);
        } else {
            ans = Math.max(f(prices, fee, i + 1, j, m), f(prices, fee, i + 1, 1, m) - prices[i]);
        }
        return m[i][j] = ans;
    }

    private int dp1(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                int ans = f[i + 1][j];
                if (j == 1) {
                    ans = Math.max(ans, f[i + 1][0] + prices[i] - fee);
                } else {
                    ans = Math.max(ans, f[i + 1][1] - prices[i]);
                }
                f[i][j] = ans;
            }
        }
        return f[0][0];
    }

    private int dp2(int[] prices, int fee) {
        int[] f = new int[2];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                int _f1 = f[1];
                if (j == 1) {
                    f[1] = Math.max(f[1], f[0] + prices[i] - fee);
                } else {
                    f[0] = Math.max(f[0], _f1 - prices[i]);
                }
            }
        }
        return f[0];
    }

    private int dp3(int[] prices, int fee) {
        int[] f = new int[2];
        for (int i = prices.length - 1; i >= 0; i--) {
            int _f1 = f[1];
            f[1] = Math.max(f[1], f[0] + prices[i] - fee);
            f[0] = Math.max(f[0], _f1 - prices[i]);
        }
        return f[0];
    }

    private int dp4(int[] prices, int fee) {
        int f0 = 0, f1 = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int _f1 = f1;
            f1 = Math.max(f1, f0 + prices[i] - fee);
            f0 = Math.max(f0, _f1 - prices[i]);
        }
        return f0;
    }

}
