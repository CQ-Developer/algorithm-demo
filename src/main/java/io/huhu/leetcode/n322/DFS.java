package io.huhu.leetcode.n322;

import java.util.Arrays;

class DFS implements Code {

    @Override
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int ans = f(coins, n - 1, amount, new int[n][amount + 1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int f(int[] coins, int i, int amount, int[][] dp) {
        if (i < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[i][amount] != 0) {
            return dp[i][amount];
        }
        int a = f(coins, i, amount - coins[i], dp);
        if (a != Integer.MAX_VALUE) {
            a += 1;
        }
        int b = f(coins, i - 1, amount, dp);
        return dp[i][amount] = Math.min(a, b);
    }

}
