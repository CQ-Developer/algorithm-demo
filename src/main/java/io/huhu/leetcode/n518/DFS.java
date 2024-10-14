package io.huhu.leetcode.n518;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return f(0, amount, coins, dp);
    }

    private int f(int i, int j, int[] coins, int[][] dp) {
        if (j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        for (int k = i; k < coins.length && coins[k] <= j; k++) {
            ans += f(k, j - coins[k], coins, dp);
        }
        return dp[i][j] = ans;
    }

}
