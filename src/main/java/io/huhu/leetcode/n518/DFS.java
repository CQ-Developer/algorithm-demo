package io.huhu.leetcode.n518;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(0, amount, coins, dp);
    }

    private int f(int i, int j, int[] coins, int[][] dp) {
        if (i == coins.length) {
            return j == 0 ? 1 : 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // 当前硬币不能选择
        if (j < coins[i]) {
            dp[i][j] = f(i + 1, j, coins, dp);
        }
        // 既可以继续选择当前硬币
        // 也可以不选择当前硬币
        else {
            dp[i][j] = f(i, j - coins[i], coins, dp) + f(i + 1, j, coins, dp);
        }
        return dp[i][j];
    }

}
